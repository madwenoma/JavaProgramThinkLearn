package learn.thread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 测试锁住主线程修改文件
 * 
 * @author biGpython
 * 
 */
public class FileLockMainThread {
	private static FileLockMainThread flmt = null;
	private static String lock = null;

	private FileLockMainThread() {
	}

	public static FileLockMainThread getInstance() {
		if (flmt == null) {
			flmt = new FileLockMainThread();
		}
		if (lock == null) {
			lock = "";
		}
		return flmt;
	}

	public synchronized void exec(int msg) throws IOException, InterruptedException {
		File file = new File("d:" + File.separator + "demo.txt");
		FileWriter writer = new FileWriter(file);
			for (int i = 0; i < 1000; i++) {
				Thread.sleep(100);
				String str = "this is thread :"
						+ Thread.currentThread().getName() + " " + msg
						+ System.getProperty("line.separator");
				writer.write(str);
				writer.flush();
				System.out.println(str);
			}
			writer.close();
	}

	public synchronized static void main(String[] args) throws IOException,
			InterruptedException {
//		FileReader reader = new FileReader(new File("d:\\1.txt"));
		File file = new File("d:\\1.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String content = null;
		int num = 0;
		while((content = reader.readLine())!= null){
			num = Integer.valueOf(content);
			num++;
		}
		FileWriter writer = new FileWriter(file);
		writer.write(num+"");
		writer.flush();
		writer.close();
		reader.close();
		
		
		System.out.println(num);
		 FileLockMainThread.getInstance().exec(num);
		 FileLockMainThread.getInstance().exec(num);
//		System.out.println(FileLockMainThread.count++);
	}
}
