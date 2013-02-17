package learn.abstractfacotry;

/**
 * @author biGpython
 * @version 1.0
 * @created 01-ÈýÔÂ-2012 21:58:32
 */
public class SqlFactory implements IFactory {


	public SqlFactory(){

	}

	@Override
	public SqlUser createUser(){
		return new SqlUser();
	}


}