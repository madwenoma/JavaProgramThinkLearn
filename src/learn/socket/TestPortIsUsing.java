package learn.socket;
import java.io.IOException;
import java.net.*;
/**
 * 测试端口是否被占用
 * @author biGpython
 *
 */
public class TestPortIsUsing {
	
	public static void main(String[] args) throws UnknownHostException  {
		
		InetAddress address = InetAddress.getByName("localhost");
		try {
			Socket s = new Socket(address, 8099);
			System.out.println("端口被占用");
		} catch (IOException e) {
			System.out.println("端口未被占用");
			e.printStackTrace();
		}
		
		
	}
	
	public static void testSocket() throws IOException{
		ServerSocket ss = new ServerSocket(3306);
		
	}
	
	
}
