package learn.thread;

public class SingeltonClass {
	private static SingeltonClass sc = null;
	public static int count = 1;
	private  SingeltonClass(){
		
	}
	
	public static SingeltonClass getInstance(){
		if(sc == null){
			sc = new SingeltonClass();
		}
		return sc;
	}
}
