package hienpd.cp.leetcode.top150.easy;

import java.util.ArrayList;
import java.util.List;

// Category: Intervals
// https://leetcode.com/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		return twoPointer(nums);
	}

	// time complexity: O(n)
	private List<String> twoPointer(int[] nums) {
		int leftPt, rightPt;
		leftPt = 0;

		var result = new ArrayList<String>();
		while (leftPt < nums.length) {
			rightPt = leftPt;
			while (rightPt + 1 < nums.length && nums[rightPt + 1] == nums[rightPt] + 1) {
				rightPt++;
			}
			if (leftPt == rightPt) {
				result.add(String.format("%d", nums[leftPt]));
			} else {
				result.add(String.format("%d->%d", nums[leftPt], nums[rightPt]));
			}
			leftPt = rightPt + 1;
		}
		return result;
	}
}
