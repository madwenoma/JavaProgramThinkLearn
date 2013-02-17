package learn.event;

import java.util.EventListener;

public interface DemoListener extends EventListener{//EventListener中没有任何方法，可以自己定义任何方法，也可以像本接口——定义一个公共回调方法
	  public void demoListener(DemoEvent dm);
}
