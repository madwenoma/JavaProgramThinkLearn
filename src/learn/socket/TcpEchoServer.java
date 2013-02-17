package learn.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TcpEchoServer extends MSTServerBase{
	@Override
	public void run(){
		try {
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			int c = 0;
			while ((c=in.read()) != -1){
				
				System.out.println(c);
				if(c != -1){ 
					out.write(c);
				}
			}
			in.close();
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		startServer(8999, TcpEchoServer.class);
	}
}
