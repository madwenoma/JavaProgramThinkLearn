package learn.event;

public class TestEvent {
	//测试入口类
	DemoSource ds;

	
	public TestEvent(){
		ds = new DemoSource();
		DemoListener dl = new ListenerOne();
		//添加监听器
		ds.addListener(dl);
		ds.addListener(new DemoListener(){

			@Override
			public void demoListener(DemoEvent dm) {
				System.out.println("匿名内部类监听器");
			}
			
		});
		
	}
	//触发事件
	public void begin(){
		System.out.println("调用时触发");
		ds.notifyDemoEvent();
	}
	
	
	
	public static void main(String[] args) {
		new TestEvent().begin();
	}
}
