package learn.exception.inherited;

import java.io.FileNotFoundException;

class SomeOtherException extends Exception {
}

public class RunTimeExceptionDemo {
	public static void main(String[] args) {
		RunTimeExceptionDemo demo = new RunTimeExceptionDemo();

//		/demo.testRunTime(1);

		for (int i = 0; i < 4; i++) {
			try {
				if (i < 3) {
					demo.testRunTime(i);
				} else {
					throw new SomeOtherException();
				}
			} catch (SomeOtherException soe) {
				soe.printStackTrace();
			} catch (RuntimeException re) {
				try {
					throw re.getCause();
				} catch (FileNotFoundException fnfe) {
					fnfe.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (RuntimeException e) {
					e.printStackTrace();
				} catch (Throwable te) {
					te.printStackTrace();
				}
			}
		}

	}

	public void testRunTime(int type) {
		try {
			switch (type) {
			case 0:
				throw new FileNotFoundException();
			case 1:
				throw new ClassNotFoundException();
			case 2:
				throw new RuntimeException("where am i");
			default:
				return;
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
