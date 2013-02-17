package learn.junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class CalculatorTest2 {
	private int a;
	private int b;
	private int expected;
	private Calculator cal = new Calculator();
	@Before
	public void setUp() throws Exception {
	}

	public CalculatorTest2(int a, int b, int expected) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	@Test
	public void testAdd() {
		assertEquals(expected,cal.add(a,b));
	}

	@SuppressWarnings("rawtypes")
	@Parameters
	public static Collection datas() {
		return Arrays.asList(new Object[][] { { 1, 2, 3 }, { 2, 2, 4 },
				{ 3, 3, 6 } });
	}

}
