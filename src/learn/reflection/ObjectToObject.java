package learn.reflection;

import java.lang.reflect.Field;

//�ṩһ��ģ�͸��Ƶ���һ��ģ�͵ķ��������ݺ������Ŀ�е�DTO��Model��ת��
public class ObjectToObject {
	
	public static <T1,T2> T2 SourceToAnother(T1 obj1, T2 obj2){
		Field[] f1 = obj1.getClass().getFields();
		
		Field[] f2 = obj2.getClass().getFields();
		return null;
	}
	
	public static void main(String[] args) {
		
	}
	
}
