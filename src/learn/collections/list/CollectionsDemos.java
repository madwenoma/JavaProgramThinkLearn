package learn.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 本类主要用于研究Collections的一些使用方法
 * @author Administrator
 *
 */
public class CollectionsDemos {
	public static void main(String[] args) {
		testBinarySearch();
	}
	
	
	private static void testBinarySearch() {
		class Person implements Comparable<Integer>{
			public int id;
			public Person(int id) {
				this.id = id;
			}
			@Override
			public String toString() {
				return "Person [id=" + id + "]";
			}
			
			@Override
			public int compareTo(Integer o) {
				// TODO Auto-generated method stub
				return id - o;
			}
		}
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(1000));
		persons.add(new Person(1100));
		persons.add(new Person(1200));
		persons.add(new Person(1300));
		persons.add(new Person(1400));
		System.out.println(persons);
		System.out.println(Collections.binarySearch(persons, 1300));
	}
	
	
}
