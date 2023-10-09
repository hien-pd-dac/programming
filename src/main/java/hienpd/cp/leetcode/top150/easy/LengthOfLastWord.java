package hienpd.cp.leetcode.top150.easy;

// import java.util.Arrays;

class LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		var splittedStrings = s.stripTrailing().split(" ");
		// var splittedStrings = s.strip().replaceAll("\s+", "\s").split(" ");
		// System.out.printf("%s%n", Arrays.toString(splittedStrings));
		return splittedStrings[splittedStrings.length - 1].length();
	}

	// optimized solution
	public static int lengthOfLastWord2(String s) {
		if (s.length() == 0) {
			return 0;
		}
		var pointer = s.length() - 1;
		while (pointer >= 0) {
			if (s.charAt(pointer) != ' ') {
				break;
			}
			pointer--;
		}
		if (pointer < 0) {
			return 0;
		}
		var endOfLastWord = pointer;
		while (pointer >= 0) {
			if (s.charAt(pointer) == ' ') {
				break;
			}
			pointer--;
		}
		return endOfLastWord - pointer;
	}

}
