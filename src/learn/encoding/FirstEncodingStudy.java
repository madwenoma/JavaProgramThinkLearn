package learn.encoding;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/**
 * 测试
 * @author biGpython
 *
 */
public class FirstEncodingStudy {
	
	public String name;
	
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		
		
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println(1);
				System.out.println(2);
				
			}
		};
		new Thread(r).start();
		String as = null;
		System.out.println(as.indexOf("a"));
		FirstEncodingStudy fes = new FirstEncodingStudy();
		String s = fes.name = "12";
		printName(s);
		
		//系统编码
		System.out.println(System.getProperty("file.encoding"));
		String text = "中文字";
		System.out.println(text);
		System.out.println(Charset.defaultCharset());
		byte[] bs = text.getBytes(Charset.defaultCharset());
		for (int i = 0; i < bs.length; i++) {
			System.out.println(bs[i]);
		}
		System.out.println("bs1 bellow____________________");
		byte[] bs1 = text.getBytes("utf-8");
		for (int i = 0; i < bs1.length; i++) {
			System.out.println(bs1[i]);
		}
	}
	
	public static void printName(String name){
		if(name.equals("tom")){
			System.out.println("tom");
		}
	}
	
	
}
