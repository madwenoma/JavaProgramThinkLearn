package learn.annotation.apt;
/**
 * apt注解处理器 java编程思想 P630
 * @author biGpython
 *
 */

@ExtractInterface(value = "IMultiplier") //如果只有一个value 可以写成 @ExtractInterface("IMultiplier")
public class Multiplier {
	public int multiply(int x, int y) {
		int total = 0;
		for (int i = 0; i < x; i++) {
			total = add(total, y);
		}
		return total;
	}

	private int add(int x, int y) {

		return x + y;
	}

	public static void main(String[] args) {
		Multiplier m = new Multiplier();
		System.out.println("11 * 16 = " + m.multiply(11, 16));
	}
}
