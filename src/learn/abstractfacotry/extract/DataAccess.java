package learn.abstractfacotry.extract;

import learn.abstractfacotry.IUser;

/**
 * 抽象出一个类，除去工厂的繁冗写法
 * 
 * @author biGpython
 *
 */
public class DataAccess {
	
	
	public IUser createUser(String dbType) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		
		Class<?> c1 =  Class.forName(dbType);
		
		return (IUser)c1.newInstance();
		
	}
	
	
	/*
	 * 多个表 可以返回多个IDept IProduct等对象
	 */
	
	
}
