package learn.event;

import java.util.EventObject;
import java.util.EventListener;
import java.util.*;
//ReadMe:�����ǵ������࣬�����˱����е�����������й��ܣ��Ǿ�������֮���д�ġ�

/**
 * �¼��� �̳�java.util.EventObject 
 * ��ʵ������һ��Object�Ķ���MyEvent���� �����¼�ԴObject���������ɶ��壩����������
 */
class MyEvent extends EventObject{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//���췽��
    public MyEvent(Object source){
        super(source);
    }

}




/**
 *���������лص�������������Ӧ
 */
class MyEventListener implements java.util.EventListener{
    
    //�ص�����
    public void callBack(MyEvent event){
        String name = ((DataSource)(event.getSource())).name;
        System.out.println("my event listener;GET NAME :" + name);
    }

}

/**
 *  �¼�Դ���¼������ĵط��������¼�Դ��ĳ�����Ի�״̬�����˸ı�(����BUTTON��������TEXTBOX��ֵ�����ı�ȵ�)
 *  ����ĳ���¼����������仰˵������������Ӧ���¼�����
 *  ��Ϊ�¼�������Ҫע�����¼�Դ��,�����¼�Դ����Ӧ��Ҫ��ʢװ������������(List,Set�ȵ�)��
 *	����Ա�����������е�����
 */
class DataSource{
    /*������ǰ�¼������еļ�����*/
    private ArrayList<EventListener> listeners = new ArrayList<EventListener>();
    /*�¼�Դ�������ԣ����Ծ��ڼ������е���*/
    public String name = "�¼�Դ����";
    
    /**
     * ����¼���������ע���¼����¼�Դ��ע���¼��ļ����������¼�Դ����ӵģ�
     * ���һ�����һ����
     */
    public void addListener(java.util.EventListener listener){
        listeners.add(listener);
    }

    /**
     * ֪ͨ���¼������еļ�������ִ�лص������������¼�������Ӧ
     * �´����е���������еĲ˵��͸���ʦȥִ��
     * */
    public void notifyAllListeners(){
        if(listeners.size() > 0){
            for(EventListener listener: listeners){
               ((MyEventListener)listener).callBack(new MyEvent(this));
               
            }
        }
    }
    
    /**����onTick����ʱ�����������¼�*/    
    public void onTick(){
        notifyAllListeners();
    }

}

public class MyEventDemo {
    public static void main(String[] args){
        DataSource ds = new DataSource();//�¼�Դ���󣬿����Լ�����ĳ������
        ds.addListener(new MyEventListener());//��Ӽ�����
        ds.onTick();//����Ա�ж������������ɲ˵��͸���ʦ����ʼ���ˡ�
    }
}
