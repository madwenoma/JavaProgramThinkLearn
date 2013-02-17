package learn.exception;

public class TestCarControl {
	public static void main(String[] args) throws Exception {
		CarControl bmw = new BMWControl();
//		bmw.run();
		CarControl redFlag = new RedFlagControl();
		redFlag.run();
	}
}
