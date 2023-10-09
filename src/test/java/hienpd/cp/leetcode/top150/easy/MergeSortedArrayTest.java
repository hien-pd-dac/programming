package hienpd.cp.leetcode.top150.easy;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortedArrayTest {
	@Test
	public void test_Case() {
		var nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
		var nums2 = new int[] { 5, 5, 6 };
		MergeSortedArray.merge(nums1, 3, nums2, 3);
		assertArrayEquals("GIVEN 2 sorted arrays, WHEN merge 2 normal arrays, THEN return the correct answer.",
				nums1,
				new int[] { 1, 2, 3, 5, 5, 6 });
	}
}
