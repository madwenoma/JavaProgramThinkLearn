package learn.exception;

public abstract class CarControl {
	
	Car car = getCar();
	
	abstract Car getCar();
	public void  run() throws Exception{
		car.run();
	}
	public void stop() throws Exception{
		car.stop();
	}
	
}
