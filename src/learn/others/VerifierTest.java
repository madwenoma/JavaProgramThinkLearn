package learn.others;

import java.applet.Applet;
import java.awt.Graphics;

/**
 * 《java核心技术高级卷》P609
 * @author biGpython
 *
 */
public class VerifierTest extends Applet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void main(String[] args) {
		
	}
	
	public static int fun(){
		int m,n;
		m =1;
		n=2;
		int r = m + n;
		return r;
	}
	@Override
	public void paint(Graphics g){
		g.drawString("1+2="+fun(),20,20);
		g.draw3DRect(10, 10, 100, 30, true);
		g.drawLine(11, 11, 11, 11);
	}
	
}
