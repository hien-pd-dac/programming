package hienpd.practice.algorithm.dp;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.awt.Point;

/**
 * 
 * Cracking the coding interview Q.8.2 (p.135).
 */
class RobotInAGrip {
	private int r, c;
	private int[][] matrix;
	private boolean found;
	private Set<Point> notFoundMemo;
	private Deque<String> path;

	private Deque<Point> pathP;
	private List<Deque<Point>> allPaths;

	public RobotInAGrip(int iRow, int iCol, int[][] iMatrix) {
		r = iRow;
		c = iCol;
		matrix = iMatrix;

		found = false;
		notFoundMemo = new HashSet<Point>();
		path = new LinkedList<String>();

		pathP = new LinkedList<Point>();
		allPaths = new ArrayList<Deque<Point>>();
	}

	public String solve() {
		if (pathFromAPoint(0, 0)) {
			return String.join("-", path);
		}
		return "not found";
	}

	public void solveBT() {
		if (pathFromAPointBT(0, 0)) {
			// System.out.printf("found %d paths:%n%s%n", allPaths.size(), allPaths);
			return;
		}
		// System.out.println("not found any paths");
		return;
	}

	private boolean pathFromAPoint(int iR, int iC) {
		var p = new Point(iR, iC);
		if (iR > r - 1 || iC > c - 1 || matrix[iR][iC] == 1) {
			return false;
		}
		if (notFoundMemo.contains(p)) {
			return false;
		}
		if (iR == r - 1 && iC == c - 1) {
			return true;
		}

		if (pathFromAPoint(iR + 1, iC)) {
			path.addFirst("D");
			return true;
		}
		if (pathFromAPoint(iR, iC + 1)) {
			path.addFirst("R");
			return true;
		}
		notFoundMemo.add(p);
		return false;
	}

	private boolean pathFromAPointBT(int iR, int iC) {
		var p = new Point(iR, iC);
		pathP.addLast(p);
		if (iR > r - 1 || iC > c - 1 || matrix[iR][iC] == 1) {
			return false;
		}
		if (notFoundMemo.contains(p)) {
			return false;
		}
		if (iR == r - 1 && iC == c - 1) {
			allPaths.add(new LinkedList<Point>(pathP));
			return true;
		}

		var isFound = false;
		if (pathFromAPointBT(iR + 1, iC)) {
			isFound = true;
		}
		pathP.removeLast();
		if (pathFromAPointBT(iR, iC + 1)) {
			isFound = true;
		}
		if (!isFound) {
			notFoundMemo.add(p);
			return false;
		}
		return true;
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
