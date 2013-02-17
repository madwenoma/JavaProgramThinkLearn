package learn.reflection;

import java.lang.reflect.Field;

//提供一种模型复制到另一个模型的方法，根据红股网项目中的DTO和Model的转化
public class ObjectToObject {
	
	public static <T1,T2> T2 SourceToAnother(T1 obj1, T2 obj2){
		Field[] f1 = obj1.getClass().getFields();
		
		Field[] f2 = obj2.getClass().getFields();
		return null;
	}
	
	public static void main(String[] args) {
		
	}
	
}
