package hienpd.cp.leetcode.top150.easy;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MajorityElementTest {
	@Test
	public void testCase() {
		assertEquals("GIVEN, WHEN, THEN",
				2,
				MajorityElement.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}
}
