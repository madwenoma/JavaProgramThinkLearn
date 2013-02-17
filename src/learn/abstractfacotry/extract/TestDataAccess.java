package learn.abstractfacotry.extract;

import learn.abstractfacotry.IUser;

public class TestDataAccess {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		DataAccess da = new DataAccess();
		IUser c1 = da.createUser("learn.abstractfacotry.SqlUser");
		IUser c2 = da.createUser("learn.abstractfacotry.OraUser");
		c1.add();
		c2.delete();
		
		
	}
}
