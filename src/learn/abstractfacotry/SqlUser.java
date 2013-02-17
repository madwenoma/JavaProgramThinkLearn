package learn.abstractfacotry;

/**
 * @author biGpython
 * @version 1.0
 * @created 01-ÈıÔÂ-2012 21:58:31
 */
public class SqlUser implements IUser {

	public SqlUser(){
		
	}

	@Override
	public void add(){
		System.out.println("mysql add");
	}

	@Override
	public void delete(){
		System.out.println("mysql delete");
	}

}