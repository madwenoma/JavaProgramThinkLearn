package learn.string;

/**
 * StringBuilder‘¥¬Î—ßœ∞
 * 
 * @author biGpython
 * 
 */
public class StringBuilderSourceCodeStudy {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		StringBuffer buffer = new StringBuffer();
		String aStr = new String("abc");
		changeString(aStr);
		System.out.println(aStr);
		
		Student stu = new Student();
		stu.name = "gaara";
		changeStudent(stu);
		System.out.println(stu.name);
		
	}
	
	public static void changeString(String str){
		str = new String("asdb");
	}
	
	public static void changeStudent(Student stu){
		stu.name = "PYTHON";
	}
	
	
	
}
class Student{
	
	public String name;
}