package learn.generate;

import java.lang.reflect.Array;

/**
 * 编程思想 P384、385、386 GenerateArray
 */
public class GenerateArrayDemoOne {

	//
	static class GenerateArray1<T1> {

		private T1[] t1Arr;

		@SuppressWarnings("unchecked")
		public GenerateArray1(int size) {
			t1Arr = (T1[]) new Object[size];//转型
		}

		public void put(int index, T1 t1) {
			t1Arr[index] = t1;
		}

		public T1 get(int index) {
			return t1Arr[index];
		}

		public T1[] rep() {
			return t1Arr;
		}
	}

	//内部使用Object数组，运行时谨记操作的都是objec类型的数组。
	static class GenerateArray2<T2> {

		private Object[] objArray;

		public GenerateArray2(int size) {
			objArray = new Object[size];//
		}

		public void put(int index, T2 t2) {
			objArray[index] = t2;
		}

		@SuppressWarnings("unchecked")
		public T2 get(int index) {
			return (T2) objArray[index];
		}

		@SuppressWarnings("unchecked")
		public T2[] rep() {
			return (T2[]) objArray;
		}

	}

	//指定了class，反射实例化真正的类型。
	static class GenerateArray3<T3> {

		private T3[] t3Arr;

		@SuppressWarnings("unchecked")
		public GenerateArray3(Class<T3> type, int index) {
			t3Arr = (T3[]) Array.newInstance(type, index);//
		}

		public void put(int index, T3 t3) {
			t3Arr[index] = t3;
		}

		public T3 get(int index) {
			return t3Arr[index];
		}

		public T3[] rep() {
			return t3Arr;
		}
	}
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		/**/
		GenerateArray1<Integer> ga1 = new GenerateArray1<Integer>(3);
		ga1.put(0, 1);
		System.out.println(ga1.get(0));
		Integer i = ga1.get(0);
		try {
			Integer[] arr = ga1.rep();
		} catch (Exception e) {
			System.out.println("产生异常，由于擦除无法正常转型");
			System.out.println(e);
		}

		/**/
		GenerateArray2<String> ga2 = new GenerateArray2<String>(3);
		ga2.put(0, "abc");
		String str = ga2.get(0);
		try {
			String[] abs = ga2.rep();
		} catch (Exception e) {
			System.out.println(e);
		}
		/**/
		GenerateArray3<String> ga3 = new GenerateArray3<String>(String.class, 3);
		ga3.put(0, "abc");
		String str2 = ga3.get(0);
		String[] abs2 = ga3.rep();//可以得到
		System.out.println(String.format("成员为%s,长度为%d", str2, abs2.length));
	}

}
