package learn.concurrent;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		ConcurrentLinkedQueue clq = new ConcurrentLinkedQueue();
		clq.add("abd");
	}
}
