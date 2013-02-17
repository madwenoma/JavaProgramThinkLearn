package learn.string;

public class TestStringSomeProperty {
	public static void main(String[] args) {
		String s1 = "a";
		String s2 = s1 + "b";
		
		int a = 4;
		assert a == 5;
		String s3 = "a" + "b";
		System.out.println(s2 == "ab");//false
		System.out.println(s3 == "ab");//true
			
	}
}
