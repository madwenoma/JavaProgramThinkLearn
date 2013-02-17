package learn.abstractfacotry;

/**
 * @author biGpython
 * @version 1.0
 * @created 01-ÈýÔÂ-2012 21:58:32
 */
public class OraUser implements IUser {

	public OraUser(){

	}

	@Override
	public void finalize() throws Throwable {

	}

	@Override
	public void add(){
		System.out.println("oracle add");
	}

	@Override
	public void delete(){
		System.out.println("oracle delete");
	}

}