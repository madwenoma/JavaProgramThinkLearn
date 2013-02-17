package learn.reflection;

public class Student2 {
	public String name = "lee";
	public static String school = "¼ÓÀû¸£ÄáÑÇ";
	private int age;

	public Student2() {
		System.out.println("construcotr without arguments");
	}

	public Student2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public static String showJob() {
		System.out.println("students's job is study");
		return "study";
	}

	public int getAge() {
		return this.age;
	}

	private String showName() {
		return this.name;
	}

	public Student2 getNewStudent(String name, Integer age) {
		return new Student2(name, age);
	}
	
	public void testMethod(String name, int age){
		System.out.println("test method!");
	}
}
