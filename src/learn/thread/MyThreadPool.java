package learn.thread;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class MyThreadPool {
    
    private static MyThreadPool pool = new MyThreadPool();

    private List<MyTask> taskQueue = Collections.synchronizedList(new LinkedList<MyTask>());

    private PoolWorker[] workers;
    
    private int taskCount;
    
    private MyThreadPool(){
    	workers = new PoolWorker[5];
        for (int i = 0; i < 5; i++){
            workers[i] = new PoolWorker(taskCount);
        }
    }

    public static MyThreadPool getInstance(){
        if (pool == null)
            return new MyThreadPool();
        return pool;
    }


    public void addTask(MyTask task){
        synchronized (taskQueue){
            task.setSubmitTime(new Date().getTime());
            task.setImmediatelyExecute(false);
            taskQueue.add(task);
            taskQueue.notifyAll();
        }       
    }

    public void batchAddTasks(MyTask[] tasks){
    
    }

    // getInfo()?


    class PoolWorker extends Thread{
        
        private boolean isRunning = true;

        private int threadId;
        
        public boolean isRunning() {
			return isRunning;
		}


		public void setRunning(boolean isRunning) {
			this.isRunning = isRunning;
		}

		public PoolWorker(int threadId){
			this.threadId = threadId;
            this.start();
        }
        
        @Override
        public void run(){

            if (isRunning){
                MyTask r = null;
                synchronized(taskQueue){
                    while (taskQueue.isEmpty()){
                        try {
							taskQueue.wait(20);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
                    }
                    r = taskQueue.remove(0);
                    if (r != null){
                        if(r.isImmediatelyExecute()){
                            new Thread(r).start();
                        } else {
                            r.run();
                            System.out.println(r.getTaskName());
                        }
                    }
                }
            }
            isRunning = false;
        }
    }
    
    
    public static void main(String[] args) {
    	ExecutorService s = Executors.newCachedThreadPool();
    	
    	//MyThreadPool threadPool = MyThreadPool.getInstance();
		MyTask task = new MyTask(){

			@Override
			protected void setTaskName() {
				setTaskName("task one");
				
			}
			
			@Override
			public void run(){
				System.out.println("task one execue");
			}
		};
		
		//threadPool.addTask(task);
		
		s.execute(task);

    }
}
