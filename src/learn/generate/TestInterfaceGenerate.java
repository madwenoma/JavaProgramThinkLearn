package learn.generate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

interface TestInterface<T>{
	public T show();
}

public class TestInterfaceGenerate<T> implements TestInterface<T>{
	T t;
	
	public TestInterfaceGenerate(T t){
		this.t = t;
		System.out.println(t);
	}
	
	static class Person{
		public String name;
		public Person(){
			this.name = "BA";
		}
		@Override
		public String toString() {
			return "Person [name=" + name + "]";
		}
		
	}
	
	
	@Override
	public T show() {
		
		return (T) "123";
	}
	public TestInterfaceGenerate(){}
	
	public TestInterfaceGenerate(Class<T> tclass){
		try {
			T t = tclass.newInstance();
			System.out.println(11111);
			System.out.println(t);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		TestInterfaceGenerate<String> t = new TestInterfaceGenerate<String>();
		String s = t.show();
		System.out.println(s);
	
		Class<?> testClass = TestInterfaceGenerate.class;
		Constructor c = testClass.getDeclaredConstructor(new Class[]{Object.class});
		Object o = c.newInstance(new Object[]{"120000000003"});

		c = testClass.getDeclaredConstructor(new Class[]{Class.class});
		o = c.newInstance(new Object[]{Person.class});
		
		
		
	}

}
