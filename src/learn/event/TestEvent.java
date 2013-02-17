package learn.event;

public class TestEvent {
	//���������
	DemoSource ds;

	
	public TestEvent(){
		ds = new DemoSource();
		DemoListener dl = new ListenerOne();
		//��Ӽ�����
		ds.addListener(dl);
		ds.addListener(new DemoListener(){

			@Override
			public void demoListener(DemoEvent dm) {
				System.out.println("�����ڲ��������");
			}
			
		});
		
	}
	//�����¼�
	public void begin(){
		System.out.println("����ʱ����");
		ds.notifyDemoEvent();
	}
	
	
	
	public static void main(String[] args) {
		new TestEvent().begin();
	}
}
