package learn.collections.map;

import java.util.HashMap;




public class TestMapEntry {
	public static void main(String[] args) {
		HashMap<String, Integer> hs = new HashMap<String, Integer>();
		hs.put("a", 1);
		hs.put("b", 2);
		System.out.println(hs.get("b"));
		System.out.println(hs.entrySet().iterator().next().setValue(3));
		System.out.println(hs.entrySet().iterator().next().getValue());
		System.out.println(hs.entrySet().iterator().next().getKey());
		System.out.println(hs.get("b"));
		
		
	}
}