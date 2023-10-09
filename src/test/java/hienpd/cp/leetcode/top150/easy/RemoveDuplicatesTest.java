package hienpd.cp.leetcode.top150.easy;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class RemoveDuplicatesTest {
	@Test
	public void testCase() {
		var nums = new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		var size = RemoveDuplicates.removeDuplicates(nums);
		assertEquals("compare size", 5, size);
		assertArrayEquals("GIVEN ..., WHEN ..., THEN ...",
				new int[] { 0, 1, 2, 3, 4 },
				Arrays.copyOfRange(nums, 0, size));

	}
}
