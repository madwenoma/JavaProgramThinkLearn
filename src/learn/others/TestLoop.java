package learn.others;

public class TestLoop {
	public static boolean foo(char c) {
		System.out.println(c);
		return true;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			System.out.println(i);
		}
		int i = 0;
		for (foo('A'); foo('B') && i < 2; foo('C')) {
			i++;
			foo('D');
		}
	}

}
