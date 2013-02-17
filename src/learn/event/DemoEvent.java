package learn.event;
import java.util.EventObject;

public class DemoEvent extends EventObject{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DemoEvent(Object source) {
		super(source);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	private Object source;
	
	public DemoEvent(Object source) {
		super(source);
		this.source = source;

	}

    public Object getSource(){
        return source;
    }*/

    public void say(){
        System.out.println("this is say method");
    }

}
