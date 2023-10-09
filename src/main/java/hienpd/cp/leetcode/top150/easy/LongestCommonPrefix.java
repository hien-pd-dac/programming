package hienpd.cp.leetcode.top150.easy;

class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		return sol1(strs);
	}

	private String sol1(String[] strs) {
		var sample = strs[0];
		var longestLen = 0;
		for (var i = 0; i < sample.length(); i++) {
			var curChar = sample.charAt(i);
			boolean cond = true;
			for (var str : strs) {
				if (str.length() < i + 1 || str.charAt(i) != curChar) {
					cond = false;
					break;
				}
			}
			if (!cond) {
				break;
			}
			longestLen++;
		}
		return sample.substring(0, longestLen);
	}
}
