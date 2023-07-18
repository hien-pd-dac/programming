package hienpd.practice.dynamic_programming;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * Cracking the coding interview Q.8.2 (p.135).
 */
public class RobotInAGrip {
	private int r, c;
	private int[][] matrix;
	private boolean found;
	private Set<Integer> notFoundMemo;
	private Deque<String> path;

	public RobotInAGrip(int iRow, int iCol, int[][] iMatrix) {
		r = iRow;
		c = iCol;
		matrix = iMatrix;

		found = false;
		notFoundMemo = new HashSet<Integer>();
		path = new LinkedList<String>();
	}

	public String solve() {
		pathFromAPoint(0, 0);
		if (!found) {
			return "not found";
		}

		return String.join("-", path);
	}

	private void pathFromAPoint(int iR, int iC) {
		if (notFoundMemo.contains(iR * c + iC)) {
			return;
		}
		if (iR == r - 1 && iC == c - 1) {
			found = true;
			return;
		}

		if (iR < r - 1 && matrix[iR + 1][iC] == 0) {
			path.addLast("D");
			pathFromAPoint(iR + 1, iC);
			if (found) {
				return;
			}
			path.removeLast();
		}
		if (iC < c - 1 && matrix[iR][iC + 1] == 0) {
			path.addLast("R");
			pathFromAPoint(iR, iC + 1);
			if (found) {
				return;
			}
			path.removeLast();
		}
		notFoundMemo.add(iR * c + iC);
		return;
	}

	public String toString() {
		return "RobotInAGrip{\n" +
				"  r=" + r + ",\n" +
				"  c=" + c + ",\n" +
				"  found=" + found + ",\n" +
				"  path=" + path + ",\n" +
				"}\n";
	}
}
