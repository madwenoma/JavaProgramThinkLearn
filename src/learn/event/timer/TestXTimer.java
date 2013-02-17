package learn.event.timer;

import learn.event.DemoEvent;
import learn.event.DemoListener;

public class TestXTimer {
	
	public static void main(String[] args) {
		XTimer timer = new XTimer();
		timer.setEnable(false);
		timer.addEvent(new DemoListener() {
			
			@Override
			public void demoListener(DemoEvent dm) {
				dm.getSource();
				System.out.println("定时任务要执行的事件 被执行了");
			}
		});
		
		timer.setEnable(true);
		
	}
}
