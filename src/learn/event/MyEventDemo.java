package learn.event;

import java.util.EventObject;
import java.util.EventListener;
import java.util.*;
//ReadMe:该类是单独的类，集中了本包中的其他类的所有功能，是经过整理之后编写的。

/**
 * 事件类 继承java.util.EventObject 
 * 其实就是有一个Object的对象，MyEvent对象 含有事件源Object（可以自由定义）——构造器
 */
class MyEvent extends EventObject{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//构造方法
    public MyEvent(Object source){
        super(source);
    }

}




/**
 *监听器，有回调函数，作出回应
 */
class MyEventListener implements java.util.EventListener{
    
    //回调方法
    public void callBack(MyEvent event){
        String name = ((DataSource)(event.getSource())).name;
        System.out.println("my event listener;GET NAME :" + name);
    }

}

/**
 *  事件源。事件发生的地方，由于事件源的某项属性或状态发生了改变(比如BUTTON被单击、TEXTBOX的值发生改变等等)
 *  导致某项事件发生。换句话说就是生成了相应的事件对象。
 *  因为事件监听器要注册在事件源上,所以事件源类中应该要有盛装监听器的容器(List,Set等等)。
 *	服务员？？接受所有的命令
 */
class DataSource{
    /*包含当前事件上所有的监听器*/
    private ArrayList<EventListener> listeners = new ArrayList<EventListener>();
    /*事件源上有属性，可以就在监听器中调用*/
    public String name = "事件源对象";
    
    /**
     * 添加事件监听器，注册事件到事件源（注：事件的监听器是在事件源中添加的）
     * 添加一条命令，一道菜
     */
    public void addListener(java.util.EventListener listener){
        listeners.add(listener);
    }

    /**
     * 通知该事件上所有的监听器，执行回调函数，即对事件作出回应
     * 下达所有的命令，把所有的菜单送给厨师去执行
     * */
    public void notifyAllListeners(){
        if(listeners.size() > 0){
            for(EventListener listener: listeners){
               ((MyEventListener)listener).callBack(new MyEvent(this));
               
            }
        }
    }
    
    /**调用onTick方法时，触发所有事件*/    
    public void onTick(){
        notifyAllListeners();
    }

}

public class MyEventDemo {
    public static void main(String[] args){
        DataSource ds = new DataSource();//事件源对象，可以自己定义某个对象
        ds.addListener(new MyEventListener());//添加监听器
        ds.onTick();//服务员行动，触发动作吧菜单送给厨师，开始做菜。
    }
}
