package learn.socket;
import java.io.IOException;
import java.net.*;
/**
 * ���Զ˿��Ƿ�ռ��
 * @author biGpython
 *
 */
public class TestPortIsUsing {
	
	public static void main(String[] args) throws UnknownHostException  {
		
		InetAddress address = InetAddress.getByName("localhost");
		try {
			Socket s = new Socket(address, 8099);
			System.out.println("�˿ڱ�ռ��");
		} catch (IOException e) {
			System.out.println("�˿�δ��ռ��");
			e.printStackTrace();
		}
		
		
	}
	
	public static void testSocket() throws IOException{
		ServerSocket ss = new ServerSocket(3306);
		
	}
	
	
}
