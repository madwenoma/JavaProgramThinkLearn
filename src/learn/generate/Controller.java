package learn.generate;

import java.lang.reflect.Constructor;

class Tool<T> {
	public T createObje(Class<T> c) throws Exception {
		return c.newInstance();
	}

}

/**
 * 模拟在红股网项目中cms控制器中CurrentService 关联：@see FirstController
 * 
 * @author Administrator
 * 
 * @param <IService>
 */
public class Controller<T extends ServiceT, V extends IService<DTO>, DTO> {

	private T t;

	//在这里面实例化ExpertService类，调用其有参构造函数
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public T getCurrentService(Class<T> serviceClass, String iserviceName) throws Exception {
		if (t == null) {
			Constructor c = serviceClass.getConstructor(String.class);
			Object o = c.newInstance(iserviceName);
			t = (T)o;
			return t;
		} else {
			return t;
		}

	}

	static class Person {
		public String name;
		public int age;

		public Person() {
			System.out.println("constructor invoked");
			name = "tom";
			age = 21;
		}

		@Override
		public String toString() {
			return name + age;
		}
	}

	public static void main(String[] args) throws Exception {
		System.out.println(new Tool<Person>().createObje(Person.class));
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
