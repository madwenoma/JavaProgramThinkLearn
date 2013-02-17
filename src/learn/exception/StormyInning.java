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
	 * 该constructor必须抛出 基类constructor抛出的异常
	 * @throws BaseballException
	 */
	public StormyInning() throws BaseballException,RainedOut{
		super();	
	}

	public StormyInning(String s) throws BaseballException,Foul{
		
	}
	
	//void walk() throws PopFoul{}; 编译
	
	@Override
	public void rainHard() throws RainedOut {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atBat() throws Foul, Strike {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void event() throws Foul{}//想要重载event 就不能抛出异常 或抛出基类异常的派生类异常

}
