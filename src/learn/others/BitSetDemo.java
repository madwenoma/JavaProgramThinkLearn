package learn.others;

import java.util.BitSet;

/**
 * BitSet 类的基础用法
 * 
 * @author biGpython
 * 
 */
class WhichChars {
	BitSet set = new BitSet();

	public WhichChars(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			set.set(c);// 在char所代表的位 bitset中的boolean值为真
		}
		for (int i = 0; i < set.size(); i++) {
			if (set.get(i)) {
				System.out.println((char) i);
			}
		}
	}
}

public class BitSetDemo {

	public static void testBitSetMethod() {
		BitSet bitSet = new BitSet();
		String[] names = { "Lord", "Python", "Danies", "Tom" };
		for (int i = 0; i < names.length; i++) {
			if (names[i].length() % 2 == 0) {
				bitSet.set(i);
			}
		}
		System.out.println(bitSet.size());

		for (int i = 0; i < bitSet.length(); i++) {
			System.out.println(bitSet.get(i));
		}

		BitSet bitSet2 = new BitSet();

		for (int i = 0; i < 4; i++) {
			bitSet2.set(i);
		}
		System.out.println(bitSet2);
		System.out.println(bitSet);
		bitSet2.andNot(bitSet);
		System.out.println(bitSet2);
	}

	public static void main(String[] args) {
		int a = 0;
		int b = 0;
		System.out.println(++b);
		System.out.println(a++);
		// testBitSetMethod();
		for (int i = 0; i < 10; ++i) {
			System.out.println(i);
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(i);
		}

		new WhichChars("get out");
	}

}