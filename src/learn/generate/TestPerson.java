package learn.generate;

import java.util.ArrayList;

public class TestPerson {
	public static void main(String[] args) {
		Contact contact = new Contact("17033331111", "°Â¿ËÀ¼É½Âö");
		Introduction in = new Introduction("Saer", 1000);
		
		Person<Contact> person1 = new Person<Contact>(contact);
		
		Person<Introduction> person2 = new Person<Introduction>(in);
		
		System.out.println(person1.getInfo());
		
		System.out.println(person2.getInfo());
		

		ArrayList<Object> lo = null;
		ArrayList<?> l = null;
		ArrayList<String> ls = new ArrayList<String>();
		ls.add("1");
		//lo = ls;  //error ±àÒë´íÎó
		
		l = ls;
//		l.add("1"); // ±àÒë´íÎó
		
		
		
		
		
	}
}
