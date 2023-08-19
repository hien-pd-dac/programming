package hienpd.practice.algorithm.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RecursiveMultiplyTest {
	@Test
	public void test_Case() {
		assertEquals(6, new RecursiveMultiply(2, 3).solve());
		assertEquals(15, new RecursiveMultiply(5, 3).solve());
		assertEquals(56088, new RecursiveMultiply(123, 456).solve());
	}
}
