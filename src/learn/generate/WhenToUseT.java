package learn.generate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * һ���ܺõ� ��ʱʹ��ͨ���?
 * ��ʱʹ��T
 * @author biGpython
 * ������
 * 
 * static void fromArrayToCollection(Object[] a, Collection<?> c) {
    	for (Object o : a) {
        	c.add(o); // �������
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
