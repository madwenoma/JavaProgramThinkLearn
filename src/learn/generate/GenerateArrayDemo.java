package learn.generate;









public class GenerateArrayDemo {
	public static void main(String[] args) {
		System.out.println(getArray(11,2)[0]);
		
		int[] a = {1,2};
		String[] b = {"a","b"};
		System.out.println(getArrayTwo(b)[1]);
		
	}
	
	public static <T> T[] getArray(T...args){
		return args;
	}
	
	public static <T> T[] getArrayTwo(T[] param){
		return  param;
	}
	
	Object a[] = new Object[]{"ad",1,1.4};
	
}
