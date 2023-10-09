package hienpd.cp.leetcode.top150.easy;

class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		var curPosOfT = 0;
		// loop through each character c of s
		for (var c : s.toCharArray()) {
			// interate t until found a character matching c
			while (curPosOfT < t.length() && t.charAt(curPosOfT) != c) {
				curPosOfT++;
			}
			// if not found any, return false
			if (curPosOfT >= t.length()) {
				return false;
			}
			curPosOfT++;
		}

		return true;
	}
}
