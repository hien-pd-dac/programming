package hienpd.cp.leetcode.top150.easy;

import java.util.LinkedList;

// Category: Stack
// https://leetcode.com/problems/valid-parentheses/description/?envType=study-plan-v2&envId=top-interview-150
public class ValidParentheses {
	public boolean isValid(String s) {
		return stack(s);
	}

	// time complexity: O(n)
	public boolean stack(String s) {
		var stack = new LinkedList<Character>();
		for (var c : s.toCharArray()) {
			if (isOpen(c)) {
				stack.addLast(genClose(c));
				continue;
			}
			var lastClose = stack.pollLast();
			if (lastClose == null || c != lastClose) {
				return false;
			}
		}
		return stack.isEmpty();
	}

	private boolean isOpen(char c) {
		boolean result;
		switch (c) {
			case '(', '[', '{':
				result = true;
				break;
			default:
				result = false;
		}
		return result;
	}

	private char genClose(char c) {
		char result;
		switch (c) {
			case '(':
				result = ')';
				break;
			case '[':
				result = ']';
				break;
			case '{':
				result = '}';
				break;
			default:
				result = ' ';
		}
		return result;
	}
}
