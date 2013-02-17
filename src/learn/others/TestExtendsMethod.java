package learn.others;

class A{
	protected int method1(int a, int b){
		return 0;
	}
	
}


public class TestExtendsMethod{

	public void oneMethod(){
		new Inner();
		this.getClass();
		this.getClass().getSuperclass().getName();
	}
	public class Inner{
		
	}

	
	public int method1(int a, int b){
		return 0;
	}
	
	protected static int method2(int a, int b){
		System.out.println(1);
		return 0;
	}
	
	public static void main(String[] args) {
		TestExtendsMethod tem = new TestExtendsMethod();
		
	}
}
