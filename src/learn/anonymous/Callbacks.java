package learn.anonymous;
/**
 * 匿名类闭包P206
 * @author biGpython
 *
 */

interface Incrementable{ 
	void increment();
}
/**
 * 
 * @author biGpython
 *
 */
class Callee1 implements Incrementable{
	private int i = 0;
	@Override
	public void increment() {
		i++;
		System.out.println(i);
	}
}
/**
 * 
 * @author biGpython
 *
 */
class MyIncrement{
	public void increment(){
		System.out.println("Ohter Operate");
	}
	static void f(MyIncrement mi){
		mi.increment();
	}
}
/**
 * 
 * @author biGpython
 *
 */
class Callee2 extends MyIncrement{
	private int i = 0;
	@Override
	public void increment(){
		super.increment();
		i++;
		System.out.println(i);
	}
	private class Closuer implements Incrementable{//闭包
		@Override
		public void increment() {
			System.out.println(Callee2.this);
			Callee2.this.increment();
		}
	}

	Incrementable getCallbackReferece() {
		return new Closuer();
	}
}
/**
 * 
 * @author biGpython
 *
 */
class Caller{
	private Incrementable callbackReference;

	Caller(Incrementable cbh) {
		callbackReference = cbh;
	}
	void go() {
		callbackReference.increment();
	}
}
/**
 * 
 * @author biGpython
 *
 */
public class Callbacks {
	public static void main(String[] args) {
		
		Callee1 c1 = new Callee1();		//Incrementable的实现
		Callee2 c2 = new Callee2();		//MyIncrement的实现
		MyIncrement.f(c2);				//父类中调用子类的实现
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReferece());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}
