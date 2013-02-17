package learn.exception.interfaces;

@SuppressWarnings("serial")
class FatherException extends Exception{}
@SuppressWarnings("serial")
class SonException extends FatherException{}

interface ExceptionInIterface{
	void run() throws FatherException;
	void kill();
}


public class InterfaceExceptionTest implements ExceptionInIterface{



	@Override
	public void kill() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() throws SonException {
		// TODO Auto-generated method stub
		
	}

}
