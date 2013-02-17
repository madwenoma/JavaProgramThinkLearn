package leanr.io;
import java.io.*;
/**
 * P929
 * @author biGpython
 *
 */
public class MemoryInput {
	public static void main(String[] args) throws IOException {
		StringReader reader = new StringReader("hello reader");
		int c;
		while ((c = reader.read()) != -1){
			System.out.println(c);
		}
	
	}
}
