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
 * 数据连接的自封装，屏蔽了 close 方法
 * 
 * @author Liudong
 */
class _Connection implements InvocationHandler {
	private final static String CLOSE_METHOD_NAME = "close";
	private Connection conn = null;
	// 数据库的忙状态
	private boolean inUse = false;
	// 用户最后一次访问该连接方法的时间
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
		// 返回数据库连接 conn 的接管类，以便截住 close 方法
		
//		Connection conn2 = (Connection) Proxy.newProxyInstance(conn.getClass().getClassLoader(), conn.getClass().getInterfaces(), this);
		/**
		 * 注意上面的方法不行原因在于 Connection.getInterfaces() 与 new Class[]{Connection.class} 的使用方法不同
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
	 * 该方法真正的关闭了数据库的连接
	 * 
	 * @throws SQLException
	 */
	void close() throws SQLException {
		// 由于类属性 conn 是没有被接管的连接，因此一旦调用 close 方法后就直接关闭连接
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
		// 判断是否调用了 close 的方法，如果调用 close 方法则把连接置为无用状态
		if (CLOSE_METHOD_NAME.equals(m.getName()))
			setInUse(false);
		else
			obj = m.invoke(conn, args);
		// 设置最后一次访问时间，以便及时清除超时的连接
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
		// 首先从连接池中找出空闲的对象
		Connection conn = getFreeConnection(0);
		if (conn == null) {
			// 判断是否超过最大连接数 , 如果超过最大连接数
			// 则等待一定时间查看是否有空闲连接 , 否则抛出异常告诉用户无可用连接
			if (getConnectionCount() >= connParam.getMaxConnection())
				conn = getFreeConnection(connParam.getWaitTime());
			else {// 没有超过连接数，重新获取一个数据库的连接
				connParam.setUser(user);
				connParam.setPassword(password);
				Connection conn2 = DriverManager.getConnection(connParam.getUrl(), user, password);
				// 代理将要返回的连接对象
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
	 * 从连接池中取一个空闲的连接
	 * 
	 * @param nTimeout
	 *            如果该参数值为 0 则没有连接时只是返回一个 null 否则的话等待 nTimeout
	 *            毫秒看是否还有空闲连接，如果没有抛出异常
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
			// 等待 nTimeout 毫秒以便看是否有空闲连接
			try {
				Thread.sleep(nTimeout);
			} catch (Exception e) {
			}
			conn = getFreeConnection(0);
			if (conn == null)
				throw new SQLException("没有可用的数据库连接");
		}
		return conn;
	}

	/**
	 * 关闭该连接池中的所有数据库连接
	 * 
	 * @return int 返回被关闭连接的个数
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
