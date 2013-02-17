package learn.exception;

class BaseballException extends Exception{}
class Foul extends BaseballException{};
class Strike extends BaseballException{};

abstract class Inning{
	public Inning() throws BaseballException{}
	public void event() throws BaseballException{}
	public abstract void atBat() throws Foul,Strike;
	public void walk(){};

}

class StormException extends Exception{}
class RainedOut extends StormException{};
class PopFoul extends Foul{}

interface Storm{
	//public void event() throws RainedOut;
	public void rainHard() throws RainedOut;
}

public class StormyInning extends Inning implements Storm{

	/**
	 * ��constructor�����׳� ����constructor�׳����쳣
	 * @throws BaseballException
	 */
	public StormyInning() throws BaseballException,RainedOut{
		super();	
	}

	public StormyInning(String s) throws BaseballException,Foul{
		
	}
	
	//void walk() throws PopFoul{}; ����
	
	@Override
	public void rainHard() throws RainedOut {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atBat() throws Foul, Strike {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void event() throws Foul{}//��Ҫ����event �Ͳ����׳��쳣 ���׳������쳣���������쳣

}
