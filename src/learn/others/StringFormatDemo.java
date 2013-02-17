package learn.others;
/**
 * String.format()
 * @author biGpython
 * 
 */
public class StringFormatDemo {

	public static String format(byte[] data) {
		StringBuilder result = new StringBuilder();
		int n = 0;
		for (byte b : data) {
			if (n % 16 == 0)
				result.append(String.format("%05x: ", n));
			result.append(String.format("%02x", b));
			n++;
			if (n % 16 == 0)
				result.append("\n");
		}
		result.append("\n");
		return result.toString();
	}

	public static void main(String[] args) throws Exception {
		byte[] bytes = new byte[]{22,2,3};
		System.out.println(format(bytes));
	}
}
