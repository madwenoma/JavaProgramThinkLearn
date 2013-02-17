package learn.thread;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MakeLock implements Runnable{
	private String threadID = "";
	@Override
	public void run() {
		try {
			while(true) {
				test2(threadID);
				Thread.sleep(200);
			}
		} catch (IOException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	public void test2(String threadID) throws FileNotFoundException, IOException, InterruptedException{
		Lock lock = new MakeLock(threadID).getLock("d:\\demo.txt",threadID);
			System.out.println(threadID+":obtain...");
			boolean b = lock.obtain();
//当有重叠时会发生等待，所以外侧先执行isLocked()判断
 System.out.println(threadID+":obtained   "+b);
			if(b){//执行业务逻辑
				Thread.sleep(390);
				for(int i = 0 ; i < Integer.MAX_VALUE ; i ++){
					;
				}
				lock.unlock();
			}
		lock = null;
			
	}
	
	public MakeLock(String threadID){
		this.threadID = threadID;
	}
	
	public Lock getLock(String name,String threadID) {
		final StringBuffer buf = new StringBuffer();
		return FileProgrameLock.get(name,threadID);
	}
	
  
 

 

public static void main(String[] args) {
		//new AAA().test();
		System.out.println("=========================================");
		Thread th1 = new Thread(new MakeLock("==================== thread1 ===================="));
		Thread th2 = new Thread(new MakeLock("#################### thread2 ####################"));
		Thread th3 = new Thread(new MakeLock("@@@@@@@@@@@@@@@@@@@@ thread3 @@@@@@@@@@@@@@@@@@@@"));
		Thread th4 = new Thread(new MakeLock("$$$$$$$$$$$$$$$$$$$$ thread4 $$$$$$$$$$$$$$$$$$$$"));
		Thread th5 = new Thread(new MakeLock("&&&&&&&&&&&&&&&&&&&& thread5 &&&&&&&&&&&&&&&&&&&&"));
		th1.start();
		th2.start();
		th3.start();
		th4.start();
		th5.start();
	}
}