package learn.exception.inherited;

class �����쳣 extends Exception {
	private static final long serialVersionUID = 1L;
}
class �������쳣 extends �����쳣{
	private static final long serialVersionUID = 1L;
	
}

class Father {
	public void say() throws Exception {
		System.out.println("i am father say");

	}

	public void hit() throws �������쳣{
		System.out.println("father hit");
	}

}

public class Son extends Father {
	@Override
	public void say() {
		System.out.println("i am son say");
		try {
			throw new Exception();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void hit(){
		System.out.println("son hit");
	}	

	public static void main(String[] args) {
		Father father1 = new Father();
		Father father2 = new Son();
		try {
			father1.say();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			father2.say();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			father2.hit();
		} catch (�������쳣 e) {
			e.printStackTrace();
		}
		
		try {
			father1.hit();
		} catch (�������쳣 e) {
			e.printStackTrace();
		}
		
	}

}
