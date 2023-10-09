package hienpd.cp.leetcode.top150.easy;

import java.util.HashMap;

class ContainsDuplicateII {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		// return bruteforce(nums, k);
		return optimized(nums, k);
	}

	// time spent: 5min50s
	// time complexity: nums.length * k
	private boolean bruteforce(int[] nums, int k) {
		for (var i = 0; i < nums.length; i++) {
			var curNum = nums[i];
			for (var j = i + 1; j <= i + k && j < nums.length; j++) {
				if (curNum == nums[j]) {
					return true;
				}
			}
		}
		return false;
	}

	// after optimization
	// time complexity:
	// f(n+1) = f(n) + log(n) = f(n-1) + log(n-1) + log(n)
	// = 1 + log(1) + log(2) + .. + log(n)
	private boolean optimized(int[] nums, int k) {
		// declare a `valueToIdx` map to store (value, index)
		var valueToIdx = new HashMap<Integer, Integer>();
		// for i, val in nums:
		for (var i = 0; i < nums.length; i++) {
			var curNum = nums[i];
			// find this val in map
			if (!valueToIdx.containsKey(curNum)) {
				valueToIdx.put(curNum, i);
				continue;
			}

			// if exist, then check the abs(i-j) <=k
			var idx = valueToIdx.get(curNum);
			if (i - idx <= k) {
				// if OK, then return true
				return true;
			} else {
				valueToIdx.put(curNum, i);
			}

		}

		return false;
	}
}
