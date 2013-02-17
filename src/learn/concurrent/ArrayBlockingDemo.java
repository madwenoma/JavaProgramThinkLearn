package learn.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ArrayBlockingDemo {
	static class Basket {
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(3);

		public void produce() {
			try {
				bq.put("produce an apple");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public String consum() {
			try {
				return bq.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return "";
		}

	}

	static void testBasket() {
		final Basket bs = new Basket();
		class Producer implements Runnable {
			boolean flag = true;
			@Override
			public void run() {
				while (flag) {
					System.out.println("生" + System.currentTimeMillis());
					bs.produce();
					System.out.println("生完:" + System.currentTimeMillis());
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						flag = false;
					}
				}
			}
		}

		class Consumer implements Runnable {
			@Override
			public void run() {
				boolean flag = true;
				while (flag) {
					System.out.println("吃" + System.currentTimeMillis());
					System.out.println(bs.consum());
					System.out.println(bs.consum());
					System.out.println(bs.consum());
					System.out.println("吃完 " + System.currentTimeMillis());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						flag = false;
					}
				}
			}
		}

		//
		ExecutorService es = Executors.newCachedThreadPool();
		Producer p = new Producer();
		Consumer c = new Consumer();
		es.submit(p);
		es.submit(c);
		try {
			Thread.sleep(10000);

		} catch (Exception e) {
			// TODO: handle exception
		}
		es.shutdownNow();
		System.exit(0);
	}

	public static void main(String[] args) {
		testBasket();
	}

}
