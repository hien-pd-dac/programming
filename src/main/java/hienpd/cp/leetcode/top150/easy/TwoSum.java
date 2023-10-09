package hienpd.cp.leetcode.top150.easy;

import java.util.HashMap;
import java.util.HashSet;

class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		// for i,num in nums
		var blackList = new HashSet<Integer>();
		for (var i = 0; i < nums.length; i++) {
			if (blackList.contains(nums[i])) {
				continue;
			}
			// find j so that nums[j] = target - num
			for (var j = i + 1; j < nums.length; j++) {
				// if found, return [i, j]
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
			blackList.add(nums[i]);
			blackList.add(target - nums[i]);
		}

		return null;
	}

	// more optimized
	public int[] twoSum1(int[] nums, int target) {
		// store (value, index) of each num in nums to a map
		var valueToIdx = new HashMap<Integer, Integer>();
		for (var i = 0; i < nums.length; i++) {
			if (!valueToIdx.containsKey(nums[i])) {
				valueToIdx.put(nums[i], i);
			}
		}

		for (var i = 0; i < nums.length; i++) {
			var remain = target - nums[i];
			if (valueToIdx.containsKey(remain)) {
				var remainIdx = valueToIdx.get(remain);
				if (remainIdx != i) {
					return new int[] { i, remainIdx };
				}
			}
		}
		return new int[] {};
	}
}
