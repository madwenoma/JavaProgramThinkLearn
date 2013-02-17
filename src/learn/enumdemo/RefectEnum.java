package learn.enumdemo;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

/**
 * p594
 * @author Administrator
 *
 */
enum Explore{
	HREE,THERE
}

public class RefectEnum {
	public static Set<String> anylize(Class<?> enumClass){
		System.out.println("========= anylize:" + enumClass + "==========");
		for (Type t : enumClass.getGenericInterfaces()){
			System.out.println(t);
		}
		
		System.out.println("super class is :" + enumClass.getSuperclass());
		
		Set<String> methodNames = new HashSet<String>();
		for(Method method : enumClass.getMethods()){
			methodNames.add(method.getName());
		}
		System.out.println(methodNames);
		return methodNames;
	}
	
	public static void main(String[] args) {
		System.out.println(Explore.values());
		for (Explore e: Explore.values()){
			System.out.println(e);
		}

		Set<String> enumMethods    = anylize(Enum.class);
		Set<String> exploreMethods = anylize(Explore.class);
		System.out.println("exploreMethods.containsAll(enumMethods)" + exploreMethods.containsAll(enumMethods));
									exploreMethods.removeAll(enumMethods);
		System.out.println("after removeAll:" + exploreMethods);
	
	}
}
