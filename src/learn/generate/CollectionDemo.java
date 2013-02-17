package learn.generate;

import java.util.ArrayList;
import java.util.List;

/**
 * ͨ�������
 * @author biGpython
 *
 */

class Shape{
	public void draw(){
		System.out.println("draw in shape");
	}
}

class Circle extends Shape{
	@Override
	public void draw(){
		System.out.println("draw in circle");
	}
}

class Square extends Shape{
	@Override
	public void draw(){
		System.out.println("draw in square");
	}
}


public class CollectionDemo {
	
	
	public static void main(String[] args) {
		ArrayList<?> c = new ArrayList<String>();
//		c.add(new Object()); ��������κ�Ԫ�� ����Ϊ��֪������������� ��ʹָ����arrayalsit string
		
		
		ArrayList<String> c1 = new ArrayList<String>();
		c1.add("1231231");
		c1.add("bbbb");
		ArrayList<?> c2 = c1;
		for (Object object : c2) {
			System.out.println(object);
		}
		
		getElements(new Square());
		
	}
	
	public static <T extends Shape> void getElements(T param){
		
		param.draw();
		List<Shape> ls = new ArrayList<Shape>();
		ls.add(new Shape());
		ls.add(new Shape());
		ls.add(new Square());
		printAll(ls);
		
		
	}
	
	public static void printAll(List<? extends Shape> shapes){ //����shape�������� ������ȡ����
		for (Shape shape : shapes) {
			shape.draw();
		}
	}
	
	public static void addEle(ArrayList<? extends Shape> list){
//		list.add(new Shape());  //����ʧ�ܣ�?��ʾ��֪������ʲô���ͣ�����޷�����Ԫ��
	}
	
	
}
