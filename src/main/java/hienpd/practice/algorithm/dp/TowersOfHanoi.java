package hienpd.practice.algorithm.dp;

import java.util.ArrayList;
import java.util.List;

class TowersOfHanoi {
	private int n;
	private List<String> steps;

	public TowersOfHanoi(int diskNum) {
		this.n = diskNum;

		this.steps = new ArrayList<String>();
	}

	public List<String> solve() {
		towersOfHanoi(n, "A", "B", "C");
		return steps;
	}

	private void towersOfHanoi(int diskNum, String colA, String colB, String colC) {
		if (diskNum == 1) {
			steps.add(String.format("%s-%s", colA, colC));
			return;
		}
		towersOfHanoi(diskNum - 1, colA, colC, colB);
		towersOfHanoi(1, colA, colB, colC);
		towersOfHanoi(diskNum - 1, colB, colA, colC);
		return;
	}
}
