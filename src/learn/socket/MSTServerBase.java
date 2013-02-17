package learn.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MSTServerBase extends Thread{
	protected Socket socket;
	@Override
	public void run(){
		try {
			socket.getOutputStream().write("messgae of server's".getBytes());
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("rawtypes")
	public static void startServer(int port, Class cla){
		ServerSocket ssock;
//		Socket sock;
		try {
			ssock = new ServerSocket(port);
			while(true){
				Socket esock = null;
				try {
					esock = ssock.accept();
					MSTServerBase t = (MSTServerBase) cla.newInstance();
					t.socket = esock;
					t.start();
				} catch (Exception e) {
					try{esock.close();}catch (Exception e2) {}
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MSTServerBase.startServer(8999, MSTServerBase.class);
	}
}
