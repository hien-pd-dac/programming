package hienpd.cp.leetcode.top150.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
class MergeSortedArray {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		var result = solution(Arrays.stream(Arrays.copyOfRange(nums1, 0, m))
				.boxed()
				.collect(Collectors.toList()),
				Arrays.stream(nums2)
						.boxed()
						.collect(Collectors.toList()));

		System.out.printf("%s%n", result);
		for (var i = 0; i < m + n; i++) {
			nums1[i] = result.get(i);
		}
	}

	public static List<Integer> solution(List<Integer> nums1, List<Integer> nums2) {
		var llNums1 = new LinkedList<Integer>(nums1);
		var llNums2 = new LinkedList<Integer>(nums2);
		var result = new ArrayList<Integer>();

		while (!llNums1.isEmpty() || !llNums2.isEmpty()) {
			var llnums1First = llNums1.peekFirst();
			var llnums2First = llNums2.peekFirst();

			if (llnums1First == null) {
				result.addAll(llNums2);
				llNums2.clear();
			} else if (llnums2First == null) {
				result.addAll(llNums1);
				llNums1.clear();
			} else {
				if (llnums1First < llnums2First) {
					result.add(llnums1First);
					llNums1.removeFirst();
				} else {
					result.add(llnums2First);
					llNums2.removeFirst();
				}
			}
		}
		return result;
	}

	// Deprecated
	public void mergeOld(int[] nums1, int m, int[] nums2, int n) {
		var result = solutionOld(nums1, m, nums2, n);

		// re-assign nums1 for the result (due to leetcode requirement)
		for (var i = 0; i < m + n; i++) {
			nums1[i] = result[i];
		}
	}

	// Deprecated
	public static int[] solutionOld(int[] nums1, int m, int[] nums2, int n) {
		var result = new int[m + n];
		int pt1, pt2;
		pt1 = pt2 = 0;
		for (var i = 0; i < m + n; i++) {
			// find the smaller, and increase the position
			int smaller;
			if (pt1 >= m) {
				smaller = nums2[pt2];
				pt2++;
			} else if (pt2 >= n) {
				smaller = nums1[pt1];
				pt1++;
			} else {
				if (nums1[pt1] < nums2[pt2]) {
					smaller = nums1[pt1];
					pt1++;
				} else {
					smaller = nums2[pt2];
					pt2++;
				}
			}

			// record
			result[i] = smaller;
			System.out.printf("result[%d] = %d%n", i, smaller);
		}
		System.out.printf("result=%s%n", Arrays.toString(result));
		return result;
	}

}
