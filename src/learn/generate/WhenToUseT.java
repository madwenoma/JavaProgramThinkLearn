package learn.generate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 一个很好的 何时使用通配符?
 * 何时使用T
 * @author biGpython
 * 背景：
 * 
 * static void fromArrayToCollection(Object[] a, Collection<?> c) {
    	for (Object o : a) {
        	c.add(o); // 编译错误
    	}
	}

 */
public class WhenToUseT {
	
	
	public static void main(String[] args) {
		
		Integer a[] = {1,2};
		ArrayList<Integer> ls = new ArrayList<Integer>();
		test(a,ls);
		for (Integer integer : ls) {
			System.out.println(integer);
		}
		
		String[] abs = {"a","ab","abc"};
		List<String> ls2 = new ArrayList<String>();
		test(abs,ls2);
		for (String str : ls2) {
			System.out.println(str);
		}
		
		
	}
	static <T extends Object> void test(T[] ts,Collection<T> c){
		for (T t : ts) {
			c.add(t);
		}
	}
	
}
