package learn.event;

public class ListenerOne implements DemoListener{

	@Override
	public void demoListener(DemoEvent dm) {
		System.out.println("listener one");
	}
}
