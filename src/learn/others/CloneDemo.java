package learn.others;

import java.util.Arrays;

public class CloneDemo {
	public static void main(String[] args) throws CloneNotSupportedException {
		
		
		Foo foo = new Foo();
		
		System.out.println(foo);
		
		foo.a = 2;
		foo.goo = new Goo();
		Foo other = foo.clone();
		System.out.println(foo == other);// false,不是同一个对象
		System.out.println(foo.a == other.a);// true 是副本
		System.out.println(foo.goo == other.goo);// true,
		System.out.println(foo.goo.equals(other.goo));
		// 系统的clone方法只复制一层，是浅层复制。
		Goo[] ary = { new Goo(), new Goo(), new Goo() };
		Goo[] a = { ary[0], ary[1], ary[2] };
		Goo[] b = Arrays.copyOf(ary, 3);
		System.out.println(ary == b);// false
		System.out.println(ary[0] == b[0]);// true

		Goo[] c = ary.clone();
		System.out.println(ary == c);// false
		System.out.println(ary[0] == c[0]);// true

	}

}

class Foo implements Cloneable {
	int a;
	Goo goo;
	
	@Override
	protected Foo clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Foo) super.clone();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "tostring " + super.toString() ;
	}

/*	public Foo clone() {
		try {
			Foo f = (Foo) super.clone();
			return f;
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}
*/


}

class Goo {
	
}
