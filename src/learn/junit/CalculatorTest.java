package learn.junit;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class CalculatorTest {
	
	private static Calculator cal = new Calculator();
	

	@Before
	public void setUp() throws Exception {
		System.out.println("before all test method");
	}

	@Test
	public void testAdd() {
		int result = cal.add(1,3);
		assertEquals(4,result);
	}

	@Test(expected = ArithmeticException.class)
	public void testDevide() {
		cal.devide(1, 0);
	}


	@Test(timeout = 1000)
	public void testDeadLoop() {
		cal.deadLoop();
	}

}
