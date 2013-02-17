package learn.generate;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class Param{
	public int age;
	public Param(int age){
		this.age = age;
	}
	public Param(){
		System.out.println("default constructor");
	}
}
class Super{
	public Super(Param p){
		System.out.println(p.age);
	}
}
public class TestNewInstance {
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Constructor<Super> c = Super.class.getConstructor(Param.class);
		c.newInstance(new Param(1));
		//
		Constructor c1 = TestInterfaceGenerate.class.getDeclaredConstructor(new Class[]{Object.class});
		c1.newInstance(new Param(1));
	}
}
