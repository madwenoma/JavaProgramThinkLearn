package learn.exception;

class BMWControl extends CarControl{

	@Override
	Car getCar() {
		return new BMW();
	}
}



public class RedFlagControl extends CarControl{

	@Override
	Car getCar() {
		return new RedFlag();
	}

}
