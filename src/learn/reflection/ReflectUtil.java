package learn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class ReflectUtil {

	public static void main(String[] args) throws Exception {
		
		Student2 s1 = new Student2("tom", 11);
		//
		System.out.println(getProperty(s1, "name"));
		//
		System.out.println(getStaticProperty("learn.reflection.Student2",
				"school"));
		//

		System.out.println(invokeMethod(s1, "getNewStudent", new Object[] {
				"rudof", new Integer(21) }));
		
		
	}

	/**
	 * get public field
	 * 
	 * @throws Exception
	 */
	public static Object getProperty(Object owner, String fieldName)
			throws Exception {
		Class ownerClass = owner.getClass();
		Field field = ownerClass.getField(fieldName);
		Object prop = field.get(owner); // 需要借助实例来初始化 name
		return prop;
	}

	/**
	 * get the static field
	 * 
	 * @throws Exception
	 * @throws NoSuchFieldException
	 */
	public static Object getStaticProperty(String className,
			String staticFieldName) throws NoSuchFieldException, Exception {
		Class ownerClass = Class.forName(className);
		Field field = ownerClass.getField(staticFieldName);
		Object staticProp = field.get(null);
		return staticProp;
	}

	/**
	 * execute object's method
	 * 
	 * @throws Exception
	 * @throws NoSuchMethodException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Object invokeMethod(Object owner, String methodName,
			Object[] args) throws NoSuchMethodException, Exception {
		Class ownerClass = owner.getClass();

		Class[] argsClasses = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			argsClasses[i] = args[i].getClass();
		}
		Method method = ownerClass.getMethod(methodName, argsClasses);
		return method.invoke(owner, args);// 鍊熷姪瀹炰緥杩愯
	}

	/**
	 * execute some object's static method
	 * 
	 * @throws Exception
	 */
	public static Object invokeStaticMethod(String className,
			String methodName, Object[] args) throws Exception {
		Class staticClass = Class.forName(className);
		Class[] argsClasses = new Class[args.length];
		for (int i = 0; i < args.length; i++) {
			argsClasses[i] = args[i].getClass();
		}
		Method staticMethod = staticClass.getMethod(methodName, argsClasses);
		return staticMethod.invoke(null, args);// 闈欐�鏂规硶涓嶉渶瑕佸�鍔╁璞″疄渚�
	}

	/**
	 * new instance(only construcotr with arguments) (a little like prev
	 * method,because constructor is very like a static method.)
	 * 
	 * @throws Exception
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static Object newInstance(String className, Object[] constructorArgs)
			throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, Exception {
		Class objectClass = Class.forName(className);
		Class[] constructorArgsClasses = new Class[constructorArgs.length];
		for (int i = 0; i < constructorArgs.length; i++) {
			constructorArgsClasses[i] = constructorArgs[i].getClass();
		}
		Constructor c = objectClass.getConstructor(constructorArgsClasses);
		return c.newInstance(constructorArgs);
	}

}