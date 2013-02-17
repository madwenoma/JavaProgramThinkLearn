package learn.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 测试流的关闭异常处理 包装成runtime exception
 * 
 * @author biGpython
 * 
 */
public class TestPacketRuntime {
	private BufferedReader reader = null;

	public TestPacketRuntime() throws Exception  {
		try {
			reader = new BufferedReader(new FileReader("d:\\BigFoot.ini"));
			//做一些其他操作 抛出Exception异常
		} catch (FileNotFoundException e) {
			System.out.println("file not found");
			throw e;
		} catch (Exception e){
			try {
				reader.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			} //遇到其他异常关闭流
			throw e;
		}
	}

	public String getLine() {
		String s = "";
		try {
			if (reader != null) {
				 s = reader.readLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("读取一行文本出错");
		}
		return s;
	}
	
	//释放资源
	public void dispose(){
		try {
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("关闭流出错");
		}
	}
	
	public static void main(String[] args) {
		try {
			TestPacketRuntime tpr = new TestPacketRuntime();
			try{
				System.out.println(tpr.getLine());
			} catch (Exception e){
				e.printStackTrace(System.out);
				
			}finally{
				tpr.dispose();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
