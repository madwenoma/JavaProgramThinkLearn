package learn.thread;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 操作文件锁
 * 
 * @author biGpython
 * 
 */

class WriteFile extends Thread {

	FileWriter writer = null;
	String lock = "";

	public WriteFile(FileWriter writer) throws IOException {
		this.writer = writer;

	}

	@Override
	public void run() {
		
			for (int i = 0; i < 1000; i++) {
				try {
					Thread.currentThread();
					Thread.sleep(10);
					String str = "当前线程名:" + Thread.currentThread().getName()
							+ System.getProperty("line.separator");
					writer.write(str);
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}

		try {
			System.out.println("关闭");
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

public class FileLock {
	public static void main(String[] args) throws IOException {
		File file = new File("D:" + File.separator + "demo.txt");
		FileWriter writer = new FileWriter(file);
		FileWriter writer2 = new FileWriter(file);

		WriteFile wf = new WriteFile(writer);
		WriteFile wf2 = new WriteFile(writer2);

		wf.start();
		wf2.start();

	}
}
