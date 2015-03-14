import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;


public class ReverseIntegerTest {
	private ReverseInteger s = new ReverseInteger();
	@Test(timeout = 1000)
	public void testReverse() {
//		fail("Not yet implemented");
		Assert.assertEquals(321, s.reverse(123));
		assertEquals(-321, s.reverse(-123));
		assertEquals(0, s.reverse(0));
		assertEquals(0, s.reverse(1534236469));
		assertEquals(0, s.reverse(Integer.MAX_VALUE));
	}

}
