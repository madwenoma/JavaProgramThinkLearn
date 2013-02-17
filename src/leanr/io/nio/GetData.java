package leanr.io.nio;

import java.nio.ByteBuffer;

public class GetData {
	private final static int BSIZE = 1024;

	public static void main(String[] args) {
		ByteBuffer bb = ByteBuffer.allocate(BSIZE);
		int i = 0;
		while (i++ < bb.limit()) {
			if (bb.get() != 0) {
				System.out.println("no zero");
			}
		}
		System.out.println("i:" + i);
		// * Rewinds this buffer. The position is set to zero and the mark is
		// discarded.
		bb.rewind();
		bb.asCharBuffer().put("Howdy");
		char c;
		while ((c = bb.getChar()) != 0) {
			System.out.print(c + " ");
		}
		System.out.println();
		//
		bb.rewind();
		bb.asShortBuffer().put((short) 32767);
		System.out.println(bb.getShort());
	}

}
