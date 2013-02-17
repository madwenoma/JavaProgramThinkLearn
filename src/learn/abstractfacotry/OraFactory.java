package learn.abstractfacotry;

/**
 * @author biGpython
 * @version 1.0
 * @created 01-ÈýÔÂ-2012 21:58:33
 */
public class OraFactory implements IFactory {

	public OraFactory(){

	}

	@Override
	public OraUser createUser(){
		return new OraUser();
	}

}