package learn.exception;

import learn.exception.myexceptions.NarutoException;

public class FillStackTranceTest {
	
	public static void hit() throws NarutoException{
			System.out.println("exception in hit");
			throw new NarutoException("i am exception in hit()");
	}
	
	public static void gaara() throws NarutoException{
		try {
			hit();
		} catch (NarutoException e) {
			System.out.println("exception in gaara");
			e.printStackTrace();
			throw e;
		}
	}
	public static void kakasi() throws Exception{
		try {
			hit();
		} catch (NarutoException e) {
			System.out.println("exception in kakasi");
			e.printStackTrace();
			throw (Exception)e.fillInStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		try {
			gaara();
		} catch (NarutoException e) {
			System.out.println("main ---- gaara");
			e.printStackTrace();
		}
		
		try {
			kakasi();
		} catch (Exception e) {
			System.out.println("main ---- kakasi");
			e.printStackTrace();
		}
		
		
	}
}
