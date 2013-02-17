package learn.reflection;

import java.lang.reflect.*;

public class TestClass {
	public static void main(String[] args) throws Exception {
		/*
		 * Class c=Class.forName("Student"); Field[] fs=c.getDeclaredFields();
		 * System.out.println("class "+c.getSimpleName()+"{"); for(Field f:fs){
		 * System.out.println(f.getType().getSimpleName()+" "+f.getName()+";");
		 * } Method[] ms=c.getDeclaredMethods(); for(Method m:ms){
		 * System.out.print(m.getReturnType().getSimpleName()+" ");
		 * System.out.print(m.getName()+"("); Class[] ps=m.getParameterTypes();
		 * for(Class p:ps){ System.out.print(p.getSimpleName()+","); }
		 * System.out.println("){}"); } Constructor[] cons=c.getConstructors();
		 * for(Constructor con:cons){ System.out.println(c.getSimpleName()+"(");
		 * 
		 * Class[] ps=con.getParameterTypes(); for(Class p:ps){
		 * 
		 * System.out.print(p.getSimpleName()+","); }
		 * System.out.println("){}");}
		 */

		Object s = new Student("chun ", 18);
		Class c = s.getClass();
		Field[] fs = c.getDeclaredFields();
		for (Field f : fs) {
			f.setAccessible(true);
			System.out.println(f.getName() + "=" + f.get(s));
			// f.set(s,"123");
			// System.out.println(f.getName()+"="+f.get(s));
		}
		Class[] ps = {String.class, String.class};// 无参数
		Method m = c.getDeclaredMethod("studyOne", ps);
		Object[] os = {};
		m.invoke(s,"ass", "12");

		/*
		 * Class[] ps={String.class,int.class};//有参数 Method
		 * m=c.getDeclaredMethod("study",ps);//说明是哪个方法 Object[]
		 * os={"CoreJava",new Integer(3)};//简单类型变成包装类； m.invoke(s,os);
		 */
	}
}

class Student {
	private String name;
	private int age;

	public Student() {
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void study() {
		System.out.println("Student " + name + " study1");
	}

	public void studyOne(String sth, String age) {
		System.out.println(sth);
	}

	
	
	public String study(String course, int time) {
		System.out.println("Student " + name + " studies " + course + " for "
				+ time + " times");
		if (time >= 3)
			return "good";
		else
			return "bad";
	}
}