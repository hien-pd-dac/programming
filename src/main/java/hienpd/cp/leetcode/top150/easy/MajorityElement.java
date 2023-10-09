package hienpd.cp.leetcode.top150.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

class MajorityElement {

	public static int majorityElement(int[] nums) {
		return solution(Arrays.stream(nums).boxed().collect(Collectors.toList()));
	}

	public static int solution(List<Integer> nums) {
		int size = nums.size();
		var freqMap = new HashMap<Integer, Integer>();
		for (var num : nums) {
			if (!freqMap.containsKey(num)) {
				freqMap.put(num, 1);
				continue;
			}

			freqMap.put(num, freqMap.get(num) + 1);
		}
		int majority = 0;
		for (var e : freqMap.entrySet()) {
			if (e.getValue() > size / 2) {
				majority = e.getKey();
				break;
			}
		}
		return majority;
	}

}
