package learn.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 通过array直接初始化list
 * @author biGpython
 *
 */
class Beauty{
	
	static{
		System.out.println("beauty static");
	}
	
	Beauty(){
		System.out.println("constructor");
	}
}
public class InitListFromArray {
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		ArrayList<Integer> ints = new ArrayList<Integer>(Arrays.asList(1,2,3));
		Class<?> c = Class.forName("learn.collections.list.Beauty");
		Object o = c.newInstance();
		System.out.println(o instanceof Beauty);
		Map<String,Integer> map = new HashMap<String,Integer>();
		
	}
	
	
	
	
}
