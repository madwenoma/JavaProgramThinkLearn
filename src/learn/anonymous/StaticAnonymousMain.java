package learn.anonymous;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * P203
 * @author biGpython
 *
 */
public class StaticAnonymousMain {
	public void showNum(){
		System.out.println("show number 1");
	}
	public static class Tester{
		public static void main(String[] args) {
			StaticAnonymousMain sam = new StaticAnonymousMain();
			sam.showNum();
			ExecutorService s = Executors.newFixedThreadPool(1);
		
		}
	}
}
