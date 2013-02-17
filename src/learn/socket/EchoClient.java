package learn.socket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket echoClient = new Socket(InetAddress.getLocalHost(), 8999);
		echoClient.getOutputStream().write(123);
		echoClient.getOutputStream().flush();
		echoClient.getOutputStream().close();
		echoClient.close();
		System.out.println(echoClient.getInputStream().read());
		echoClient.getInputStream().close();
	}
}
