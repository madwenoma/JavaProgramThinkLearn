package learn.thread.interrupt;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 中断IO阻塞的一个略显笨拙但行之有效的方案 第697页
 * 
 * @author biGpython
 * 
 */
public class CloseResource {
	public static void main(String[] args) throws IOException, InterruptedException {

		ExecutorService exec = Executors.newCachedThreadPool();
		ServerSocket server = new ServerSocket(8088);

		InputStream in = new Socket("localhost",8088).getInputStream();
		
		exec.execute(new IOBlocked(in));
		exec.execute(new IOBlocked(System.in));
		
		TimeUnit.MILLISECONDS.sleep(100);
		
		System.out.println("shutdown all threads");
		exec.shutdownNow();
		
		TimeUnit.MILLISECONDS.sleep(1000);
		
		System.out.println("Closing " + in.getClass().getName());
		in.close();
		
		TimeUnit.MILLISECONDS.sleep(1000);
		
		System.out.println("Closing " + System.in.getClass().getName());
		System.in.close();
		
	}

}
