package hienpd.cp.leetcode.top150.easy;

class IndexFirstOccurrence {
	public int strStr(String haystack, String needle) {
		return sol1(haystack, needle);
	}

	public int sol1(String haystack, String needle) {
		return haystack.indexOf(needle);
	}

	public int sol2(String haystack, String needle) {
		int pointer = 0;
		boolean found = false;
		while (found != true) {
			while (pointer < haystack.length() && haystack.charAt(pointer) != needle.charAt(0)) {
				pointer++;
			}
			if (pointer >= haystack.length()) {
				break;
			}
			if (haystack.length() - pointer < needle.length()) {
				break;
			}
			if (haystack.substring(pointer, pointer + needle.length()).equals(needle)) {
				found = true;
				break;
			}
			pointer++;
		}
		return found ? pointer : -1;
	}
}
