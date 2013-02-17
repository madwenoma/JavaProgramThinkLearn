package jdbcpool.proxy;

import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import javax.sql.DataSource;

/**
 * �������ӵ��Է�װ�������� close ����
 * 
 * @author Liudong
 */
class _Connection implements InvocationHandler {
	private final static String CLOSE_METHOD_NAME = "close";
	private Connection conn = null;
	// ���ݿ��æ״̬
	private boolean inUse = false;
	// �û����һ�η��ʸ����ӷ�����ʱ��
	private long lastAccessTime = System.currentTimeMillis();

	_Connection(Connection conn, boolean inUse) {
		this.conn = conn;
		this.inUse = inUse;
	}

	/**
	 * Returns the conn.
	 * 
	 * @return Connection
	 */
	public Connection getConnection() {
		// �������ݿ����� conn �Ľӹ��࣬�Ա��ס close ����
		
//		Connection conn2 = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), this);
		/**
		 * ע������ķ�������ԭ������ Connection.getInterfaces() �� new Class[]{Connection.class} ��ʹ�÷�����ͬ
		 *
		 *
		 */
        for (Class c : conn.getClass().getInterfaces()) {
            System.out.println("-----"+c.getName());
        }
		Connection conn2 = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(),new Class[]{Connection.class}, this);
		return conn2;
	}

	/**
	 * �÷��������Ĺر������ݿ������
	 * 
	 * @throws SQLException
	 */
	void close() throws SQLException {
		// ���������� conn ��û�б��ӹܵ����ӣ����һ������ close �������ֱ�ӹر�����
		conn.close();
	}

	/**
	 * Returns the inUse.
	 * 
	 * @return boolean
	 */
	public boolean isInUse() {
		return inUse;
	}

	/**
	 * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object,
	 *      java.lang.reflect.Method, java.lang.Object)
	 */
	@Override
	public Object invoke(Object proxy, Method m, Object[] args)throws Throwable {
		Object obj = null;
		// �ж��Ƿ������ close �ķ������������ close �������������Ϊ����״̬
		if (CLOSE_METHOD_NAME.equals(m.getName()))
			setInUse(false);
		else
			obj = m.invoke(conn, args);
		// �������һ�η���ʱ�䣬�Ա㼰ʱ�����ʱ������
		lastAccessTime = System.currentTimeMillis();
		return obj;
	}

	/**
	 * Returns the lastAccessTime.
	 * 
	 * @return long
	 */
	public long getLastAccessTime() {
		return lastAccessTime;
	}

	/**
	 * Sets the inUse.
	 * 
	 * @param inUse
	 *            The inUse to set
	 */
	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}
}

/**
 * 
 * @author Administrator
 *
 */
public class DataSourceImpl implements DataSource {

	private ConnectionParam connParam;
	
	private List<_Connection> conns;
	//TODO
	public DataSourceImpl(ConnectionParam param) {
		this.connParam = param;
		conns = new ArrayList<_Connection>();
	}


	@Override
	public Connection getConnection() throws SQLException {
		return getConnection(connParam.getUser(), connParam.getPassword());
	}

	@Override
	public Connection getConnection(String user, String password)throws SQLException {
		// ���ȴ����ӳ����ҳ����еĶ���
		Connection conn = getFreeConnection(0);
		if (conn == null) {
			// �ж��Ƿ񳬹���������� , ����������������
			// ��ȴ�һ��ʱ��鿴�Ƿ��п������� , �����׳��쳣�����û��޿�������
			if (getConnectionCount() >= connParam.getMaxConnection())
				conn = getFreeConnection(connParam.getWaitTime());
			else {// û�г��������������»�ȡһ�����ݿ������
				connParam.setUser(user);
				connParam.setPassword(password);
				Connection conn2 = DriverManager.getConnection(connParam.getUrl(), user, password);
				// ����Ҫ���ص����Ӷ���
				_Connection _conn = new _Connection(conn2, true);
				synchronized (conns) {
					conns.add(_conn);
				}
				conn = _conn.getConnection();
			}
		}
		return conn;
	}

	/**
	 * �����ӳ���ȡһ�����е�����
	 * 
	 * @param nTimeout
	 *            ����ò���ֵΪ 0 ��û������ʱֻ�Ƿ���һ�� null ����Ļ��ȴ� nTimeout
	 *            ���뿴�Ƿ��п������ӣ����û���׳��쳣
	 * @return Connection
	 * @throws SQLException
	 */
	protected synchronized Connection getFreeConnection(long nTimeout)throws SQLException {
		Connection conn = null;
		Iterator<_Connection> iter = conns.iterator();
		while (iter.hasNext()) {
			_Connection _conn = iter.next();
			if (!_conn.isInUse()) {
				conn = _conn.getConnection();
				_conn.setInUse(true);
				break;
			}
		}
		if (conn == null && nTimeout > 0) {
			// �ȴ� nTimeout �����Ա㿴�Ƿ��п�������
			try {
				Thread.sleep(nTimeout);
			} catch (Exception e) {
			}
			conn = getFreeConnection(0);
			if (conn == null)
				throw new SQLException("û�п��õ����ݿ�����");
		}
		return conn;
	}

	/**
	 * �رո����ӳ��е��������ݿ�����
	 * 
	 * @return int ���ر��ر����ӵĸ���
	 * @throws SQLException
	 */
	public int close() throws SQLException {
		int cc = 0;
		SQLException excp = null;
		Iterator<_Connection> iter = conns.iterator();
		while (iter.hasNext()) {
			try {
				iter.next().close();
				cc++;
			} catch (Exception e) {
				if (e instanceof SQLException)
					excp = (SQLException) e;
			}
		}
		if (excp != null)
			throw excp;
		return cc;
	}
	
	
	private int getConnectionCount(){
		return conns.size();
	}

	public void initConnection() {
		
	}

	public void stop() {
		
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter printwriter) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int i) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isWrapperFor(Class<?> class1) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public <T> T unwrap(Class<T> class1) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
