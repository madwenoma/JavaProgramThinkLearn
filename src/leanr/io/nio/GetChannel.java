package leanr.io.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

//P552
public class GetChannel {
	
	private static final int BSIZE = 1024;
	
	public static void main(String[] args) throws IOException {
		
		
		FileChannel fc = new FileOutputStream("channel.txt").getChannel();
		
		fc.write(ByteBuffer.wrap(("some text").getBytes()));
		
		fc.close();
		
		
		fc = new RandomAccessFile("channel.txt", "rw").getChannel();
		fc.position(fc.size());
		fc.write(ByteBuffer.wrap(("random access file test").getBytes()));
		
		fc.close();
		
		//Read File
		fc = new FileInputStream("channel.txt").getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(BSIZE);
		fc.read(byteBuffer);
		byteBuffer.flip();//做什么用？？让他做好度被读取字节的准备，很拙劣，但是有助于或得最大速度
		while(byteBuffer.hasRemaining()){
			System.out.print((char)byteBuffer.get());
		}
		
		
		
		
		
	}
}
