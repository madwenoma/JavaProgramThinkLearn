package learn.generate;

import java.util.ArrayList;
import java.util.List;

/**
 * 通配符测试
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
//		c.add(new Object()); 不能添加任何元素 ，因为不知道？代表的类型 即使指向了arrayalsit string
		
		
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
	
	public static void printAll(List<? extends Shape> shapes){ //包括shape及其子类 都可以取出来
		for (Shape shape : shapes) {
			shape.draw();
		}
	}
	
	public static void addEle(ArrayList<? extends Shape> list){
//		list.add(new Shape());  //编译失败，?表示不知道具体什么类型，因此无法加入元素
	}
	
	
}
