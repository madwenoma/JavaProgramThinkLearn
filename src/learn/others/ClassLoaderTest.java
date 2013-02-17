package learn.others;

public class ClassLoaderTest {
	public static void main(String[] args) throws ClassNotFoundException {
		Thread t = Thread.currentThread();
		ClassLoader cl = t.getContextClassLoader();
		Class cla = cl.loadClass("java.lang.String");
		System.out.println(cla.getMethods()[0]);
	}
}
