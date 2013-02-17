package learn.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * ��ǿ��forѭ��������������Iterable�ӿڣ�����һ������������
 * �������������ͨ���Ƕ����һ��������ĳ�Ա�������øö����п��Ա����Ķ���
 * @author Administrator
 *
 */
public class IterableDemo {

	static class Person implements Iterable<Person> {
		private String name;
		private int age;
		private List<Person> children = new ArrayList<Person>();

		public Person(String name, int age, Person... persons) {
			super();
			this.name = name;
			this.age = age;
			for (Person person : persons) {
				children.add(person);
			}
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public List<Person> getChildren() {
			return children;
		}

		public void setChildren(List<Person> children) {
			this.children = children;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + ", children="
					+ children + "]";
		}

		@Override
		public Iterator<Person> iterator() {
			return children.iterator();
		}
	}

	public static void main(String[] args) {
		Person p = new Person("LEE", 21, new Person("son1", 22), new Person(
				"son2", 23));
		for (Person son : p) {
			System.out.println(son);
		}
	}
}
