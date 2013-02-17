package learn.collections.list;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;

public class TestIterator {
	public static void main(String[] args) {
		MyListTestIterator<String> mlt = new MyListTestIterator<String>(
				Arrays.asList("abc", "asd", "aaa"));
		HashSet<String> s = null;
		Hashtable<String, Integer> ht = null;
		Iterator<String> i = mlt.iterator();
		/*
		 * for (String string : mlt) { mlt.remove(string); }
		 */
		while (i.hasNext()) {
			System.out.println(i.next());
			i.remove();
		}
		
		
	}

	
}
