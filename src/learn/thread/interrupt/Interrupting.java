package learn.thread.interrupt;

import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
/**
 * 测试中断阻塞某个线程
 * java编程思想 第696页
 * sleep阻塞可中断而IO阻塞和同步方法阻塞时 无法中断。
 * @author biGpython
 *
 */
class OneThread implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}
		
	}
	
}
/**
 * 可中断的阻塞线程
 * @author biGpython
 *
 */
class SleepBlocked implements Runnable {

	@Override
	public void run() {
		try {
			TimeUnit.SECONDS.sleep(100);
		} catch (InterruptedException e) {
			System.out.println("InterruptException in SleepBlocked.");
		}
		System.out.println("Exiting SleepBlocked.run()");
	}

}
/**
 * 不可中断的阻塞线程
 * @author biGpython
 *
 */
class IOBlocked implements Runnable {
	private InputStream in;

	public IOBlocked(InputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		System.out.println("waiting for read");
		try {
			in.read();
		} catch (IOException e) {
			if (Thread.currentThread().isInterrupted()){
				System.out.println("interrupted from blocked IO");
			}else{
				throw new RuntimeException(e);
			}
		}
		System.out.println("Exiting IOBlocked.run()");
	}
}
/**
 * 不可中断的阻塞线程
 * @author biGpython
 *
 */
class SynchronizedBlocked implements Runnable {

	public synchronized void f() {
		while (true) {
			Thread.yield();
		}
	}

	public SynchronizedBlocked() {
		new Thread(){
			@Override
			public void run(){
				f();
			}
		}.start();	
	}

	@Override
	public void run() {
		System.out.println("trying to call f()");
		f();
		System.out.println("Exiting SynchronizedBlocked.run()");
	}

}

public class Interrupting {
	
	private static ExecutorService exec = Executors.newCachedThreadPool();
	
	static void test(Runnable r) throws InterruptedException{
		Future<?> f = exec.submit(r);
		TimeUnit.MILLISECONDS.sleep(100);
		System.out.println("Interrupting " + r.getClass().getName());
		f.cancel(true);
		System.out.println("Interrupt sent to " + r.getClass().getName());
	}
	
	public static void main(String[] args) throws InterruptedException {
		exec.submit(new OneThread());//ExecutorService 的submit方法可以启动线程
		
		test(new SleepBlocked());
		test(new IOBlocked(System.in));
		test(new SynchronizedBlocked());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Aborting with System.exit(0)");
		System.exit(0);
	}
	
}
