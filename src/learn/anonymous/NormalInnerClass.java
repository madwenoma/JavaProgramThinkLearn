package learn.anonymous;

public class NormalInnerClass {
	public class Inner{
		private int a;
		public Inner(int i){
			this.a = i;
		}
	}
	
	public static void main(String[] args) {
		NormalInnerClass outer = new NormalInnerClass();
		NormalInnerClass.Inner inner = outer.new Inner(1);//◊¢“‚∏√”Ô∑®
		System.out.println(inner.a);
		float f = 1.02f;
		System.out.println(f++);
		double d = 0.1D;
		System.out.println(d++);
		char c = 'a';
		System.out.println(++c);
		System.out.println(2<<3);
	}
}
