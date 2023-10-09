package hienpd.cp.leetcode.top150.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

class RemoveDuplicates {
	public static int removeDuplicates(int[] nums) {
		var result = solution(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		var size = result.size();
		for (var i = 0; i < size; i++) {
			nums[i] = result.get(i);
		}
		return size;
	}

	private static List<Integer> solution(List<Integer> nums) {
		var result = new ArrayList<Integer>();
		var set = new HashSet<Integer>();
		for (var num : nums) {
			if (!set.contains(num)) {
				set.add(num);
				result.add(num);
			}
		}
		return result;
	}
}
