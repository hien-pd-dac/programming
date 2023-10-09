package hienpd.cp.leetcode.top150.easy;

import java.util.ArrayList;

// https://leetcode.com/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
class RemoveElement {
	public int removeElement(int[] nums, int val) {
		var result = new ArrayList<Integer>();
		for (var num : nums) {
			if (num != val) {
				result.add(num);
			}
		}
		var resultSize = result.size();
		for (var i = 0; i < resultSize; i++) {
			nums[i] = result.get(i);
		}
		return resultSize;
	}
}
