package hienpd.cp.leetcode.top150.easy;

// #TwoPointers
class ValidPalindrome {
	public boolean isPalindrome(String s) {
		// remove non-alphanumberic
		var transformedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		System.out.printf("%s%n", transformedStr);

		// compare with reversed string
		var reversedStr = new StringBuilder(transformedStr).reverse().toString();
		System.out.printf("%s%n", reversedStr);
		return transformedStr.equals(reversedStr);
	}

	public boolean isPalindrome1(String s) {
		var result = true;
		var leftPos = 0;
		var rightPos = s.length() - 1;
		while (leftPos <= rightPos) {
			while (leftPos <= rightPos && !Character.isLetterOrDigit(s.charAt(leftPos))) {
				leftPos++;
			}
			while (rightPos >= leftPos && !Character.isLetterOrDigit(s.charAt(rightPos))) {
				rightPos--;
			}
			if (leftPos > rightPos) {
				break;
			}
			var leftChar = s.charAt(leftPos);
			var rightChar = s.charAt(rightPos);
			if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
				result = false;
				break;
			}
			leftPos++;
			rightPos--;
		}
		return result;
	}
}
