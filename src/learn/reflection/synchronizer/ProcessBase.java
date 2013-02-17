package learn.reflection.synchronizer;

public abstract class ProcessBase implements Runnable{
	/*execute interval*/
	private int interval;
	private int errInterval;
	private boolean isRunning;
	private boolean startFlag;

	public abstract void onStarting();
	public abstract void onStopping();
	public abstract void onTick();

	public void start(){
		onStarting();
		startFlag = true;
		isRunning = true;
		this.start();
	};
	
	public void stop(){
		onStopping();
		startFlag = false;
		isRunning = false;
	};

	public ProcessBase(int interval, int errInterval){
		this.interval = interval;
		this.errInterval = errInterval;
		
	}

	@Override
	public void run(){
		while(startFlag){

			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			onTick();
		}
	}
	
}