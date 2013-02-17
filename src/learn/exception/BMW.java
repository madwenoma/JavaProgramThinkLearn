package learn.exception;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

interface Car{
	void run()throws Exception;
	void stop()throws Exception;
}

class RedFlag implements Car{

	@Override
	public void run() throws Exception {
		System.out.println("∫Ï∆Ï∆Ù∂Ø");
		throw new IOException("∫Ï∆Ï∆Ù∂ØIO“Ï≥£");
	}

	@Override
	public void stop() throws Exception {
		
	}
	
}
public class BMW implements Car{
	@Override
	public void run() throws Exception  {
		@SuppressWarnings("unused")
		FileReader reader = new FileReader(new File("d:\\sdf.txt"));
	}

	@Override
	public void stop() throws Exception {
		
	}
	void oil(){
		
	}
	
}
