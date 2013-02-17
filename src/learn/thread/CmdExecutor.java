package learn.thread;

import java.io.*;

/**
 * 获取 cmd命令的错误流和标准流的结果
 * 
 * @author biGpython
 * 
 */

class StreamGobbler extends Thread {
	private InputStream in;

	public StreamGobbler(InputStream in) {
		this.in = in;
	}

	@Override
	public void run() {
		InputStreamReader ins = new InputStreamReader(in);
		BufferedReader reader = new BufferedReader(ins);
		String result = null;
		try {
			while ((result = reader.readLine()) != null) {
				System.out.println(result);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

public class CmdExecutor {
	public static void main(String[] args) throws IOException {
		Process process = Runtime.getRuntime().exec("cmd /c httpd -k start");
		
		new StreamGobbler(process.getErrorStream()).start();
//		new StreamGobbler(process.getInputStream()).start();
	
	
	}
}
