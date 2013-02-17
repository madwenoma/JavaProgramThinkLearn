package learn.thread;

import java.util.Date;

public abstract class MyTask implements Runnable{
	
	private long createTime;
	private long submitTime;
	private boolean isImmediatelyExecute = false;
	private String taskName;
	
	public MyTask(){
		this.createTime = new Date().getTime();
	}
	
	
	
	@Override
	public void run() {
		
	}

	protected abstract void setTaskName();
	
	
	public long getCreateTime() {
		return createTime;
	}
	
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	
	public long getSubmitTime() {
		return submitTime;
	}
	
	public void setSubmitTime(long submitTime) {
		this.submitTime = submitTime;
	}

	public boolean isImmediatelyExecute() {
		return isImmediatelyExecute;
	}

	public void setImmediatelyExecute(boolean isImmediatelyExecute) {
		this.isImmediatelyExecute = isImmediatelyExecute;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

}
