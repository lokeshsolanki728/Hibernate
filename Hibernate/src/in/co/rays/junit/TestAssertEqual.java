package in.co.rays.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestAssertEqual {
	@Test
	public void testAssertEqual() {

		int max = Calculation.findMax(new int[] { 1, 3, 4, 2, 6 });

		//assertEquals(1, max);// nhi chlega
		assertEquals(6, max);//chalega

	}
}
