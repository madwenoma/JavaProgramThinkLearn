package learn.event.timer;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

import learn.event.DemoEvent;
import learn.event.DemoListener;

//��ʱ���� �¼�Դ
public class XTimer {

    private static ArrayList<WeakReference<XTimer>> weakRefer = new ArrayList<WeakReference<XTimer>>();
//	private static final int MAX_THREAD = 20;
    
    static{
        Runnable r = new Runnable() {
        	@Override
			public void run() {
        		System.out.println("��̨�߳�����");
				while(true){
					if(weakRefer.size() > 0){
						System.out.println("weakRefer���ϲ�Ϊ��");
							for(WeakReference<XTimer> w: weakRefer){
								final XTimer timer = w.get();
								if(timer.enable){
									Runnable r = new Runnable() {
										@Override
										public void run() {
											timer.onTick();
										}
									};
									new Thread(r).start();
									try {
										Thread.sleep(2000);
									} catch (InterruptedException e) {
										e.printStackTrace();
									}
								}
							}
					}
					
				}
			}
		};
		Thread t = new Thread(r);
//		t.setDaemon(true);
		t.start();
    }
	
    public static void RegistXTimer(XTimer timer){
        weakRefer.add(new WeakReference<XTimer>(timer));
    }
    
    public static void UnRegistXTimer(XTimer timer){
        timer.setEnable(false);
    }

	private boolean enable;
	/**/
	private ArrayList<DemoListener> listeners = new ArrayList<DemoListener>();
	
	    
    public XTimer(){
        RegistXTimer(this);
        this.enable = false;

    }	

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

    //�¼���������� �ص�����
	public void addEvent(DemoListener dl) {
		
		listeners.add(dl);
	}
	
	public void onTick(){
		for (DemoListener lis : listeners) {
			lis.demoListener(new DemoEvent(this));
		}
	}
	
}
