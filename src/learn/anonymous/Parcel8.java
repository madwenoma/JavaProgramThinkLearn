package learn.anonymous;
/**
 * P197
 * @author biGpython
 *
 */
public class Parcel8 {
	public Wrapper wrapping(int x){
		return new Wrapper(x){
			@Override
			public int value(){
				return super.value() * 50;//本类要点
			}
		};
	}
	public static class Tester{
		public static void main(String[] args) {
			Parcel8 p8 = new Parcel8();
			Wrapper w = p8.wrapping(2);
			System.out.println(w.value());
		}
	}
}

/**
 * 
 */
class Wrapper{
	private int a;
	public Wrapper(int i){
		this.a = i;
	}
	public int value(){
		return a;
	}
}