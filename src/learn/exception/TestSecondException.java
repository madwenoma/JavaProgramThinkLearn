package learn.exception;
import learn.exception.myexceptions.*;
public class TestSecondException {
	
	public static void test1() throws NarutoException{
		System.out.println("test");
		throw new NarutoException();
	}
	
	public static void test2() throws NarutoException{
		try {
			test1();
		} catch (NarutoException e) {
			System.out.println("test2");
			e.printStackTrace();
			throw e;
		}
		
	}
	
	public static void test3() throws NarutoSecondException{
		try {
			test1();
		} catch (NarutoException e) {
			System.out.println("test3");
			e.printStackTrace();
			throw new NarutoSecondException(); //抛出新异常
		}
	}
	
	public static void main(String[] args) {
		
		
		
		for (int i = 0; i < 10; i++) {
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		try {
			test2();
		} catch (NarutoException e) {
			System.out.println("main test2 exception");
			e.printStackTrace();
		}
		
		try {
			test3();
		} catch (NarutoSecondException e) { //只记录在main中的异常信息
			System.out.println("main  test3 exception");
			e.printStackTrace();
		}
		
	}
}
