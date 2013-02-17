package learn.concurrent;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * CopyOnWriteArrayList是线程安全的。
 * 适用：读操作远大于写操作的场景，如缓存
 * 底层原理：通过对底层数组的完整复制，读不加锁，写加了锁。
 */
public class CopyOnWriteArrayListDemo {
	public static void main(String[] args) {
		//普通list 异常 。除非用迭代器遍历时删除
/*		List<String> list1 = new ArrayList<String>();
		list1.add("one");
		list1.add("two");
		list1.add("three");
		
		for (String string : list1) {
			//list1.add("ad"); 迭代add一样会异常，而迭代器又没有add方法,若使用list.add会造成while死循环，一直向list放元素
			//list1.remove(0); 删除异常除非用迭代器的删除
			System.out.println(list1.size());
		}
		*/
		
		//CopyOnWriteArrayList foreach可以操作 iterator不可以remove和set
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		for (String string : list) {
			list.remove(0); 	//可以删除
			list.add("test");	//可以添加
			System.out.println(list.size());
		}
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()){
//			it.remove(); //对于CopyOnWriteArrayList 是不允许在迭代器里进行删除操作
			list.add("test"); //导致死循环，一直添加元素，while条件不会终止
		}
		System.out.println(list.size());
		
	}
}
