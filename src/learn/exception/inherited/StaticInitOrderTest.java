package learn.exception.inherited;

import java.util.HashMap;
import java.util.Map;

/**
 * ¾²Ì¬³õÊ¼»¯Ë³Ðò
 * @author biGpython
 *
 */

class Fahter{
	public static int a = 0;
	
	static{
		System.out.println("father static");
	}
}
class Son1 extends Fahter{
	public static int b = 1;
	static{
		System.out.println("son static");
	}
}

public class StaticInitOrderTest {
	private static Map<String, String> map = new HashMap<String, String>();
	static{
		System.out.println(map.size());
		map.put("key1", "value1");
		map.put("key2", "value2");
		map.put("key3", "value3");
	}
	
	
	public static void main(String[] args) {
		StaticInitOrderTest s = new StaticInitOrderTest();
		
		StaticInitOrderTest s1 = new StaticInitOrderTest();
		int a = 0;
		System.out.println(a=100);
	}
}
