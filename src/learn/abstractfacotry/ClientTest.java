package learn.abstractfacotry;
/**
 * ≤‚ ‘≥ÈœÛπ§≥ß
 * @author biGpython
 *
 */
public class ClientTest {
	public static void main(String[] args) {
		IFactory mysqlFactory = new SqlFactory();
		IFactory oracleFactory = new OraFactory();
		IUser sqluser = mysqlFactory.createUser();
		IUser orauser = oracleFactory.createUser();
		sqluser.add();
		orauser.add();
		sqluser.delete();
		orauser.delete();
	}
}
