package leanr.io.nio;

import java.nio.*;
import java.nio.channels.FileChannel;
import java.io.*;


// P563 ÄÚ´æÓ³ÉäÎÄ¼þ
public class LargeMappedFiles {
	
	static int length = 0x8FFFFFF;
	
	public static void main(String[] args) throws FileNotFoundException, IOException {
		MappedByteBuffer out = new RandomAccessFile("test.data", "rw").getChannel().map(FileChannel.MapMode.READ_WRITE, 0, length);
		for (int i = 0; i < length; i++) {
			out.put((byte)'x');
		}
		
		System.out.println("write finished");

		for (int i = length / 2; i < length / 2 + 6; i++) {
			System.out.println((char)out.get(i));
		}
		
	}
}
