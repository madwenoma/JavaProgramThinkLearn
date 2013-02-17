package learn.abstractfacotry.extract;

import learn.abstractfacotry.IUser;

/**
 * �����һ���࣬��ȥ�����ķ���д��
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
	 * ����� ���Է��ض��IDept IProduct�ȶ���
	 */
	
	
}
