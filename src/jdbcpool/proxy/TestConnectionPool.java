package jdbcpool.proxy;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NameAlreadyBoundException;
import javax.naming.NameNotFoundException;
import javax.sql.DataSource;

public class TestConnectionPool {
	public static void main(String[] args) throws NameAlreadyBoundException, ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException, NameNotFoundException {

		
		
		
		
		 String name = "pool"; 
		 String driver = "oracle.jdbc.driver.OracleDriver"; 
		 Class.forName(driver);
		 String url = "jdbc:oracle:thin:@218.1.71.147:1521:orcl"; 
		 ConnectionParam param = new ConnectionParam(driver,url,"SCUSER","SCUSER"); 
		 param.setMinConnection(1); 
		 param.setMaxConnection(5); 
		 param.setTimeoutValue(20000); 
		 ConnectionFactory.bind(name, param); 
		 System.out.println("bind datasource ok."); 
		 
		 DataSource ds = ConnectionFactory.lookup("pool");
		 try {
			 for (int i = 0; i < 10; i++) {
				 Connection con = ds.getConnection();
				 System.out.println(con);
				 con.close();
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.unbind("pool");
			System.out.println("unbine success");
		}
	}
}
