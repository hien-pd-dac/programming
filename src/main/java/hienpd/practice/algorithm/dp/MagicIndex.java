package hienpd.practice.algorithm.dp;

/**
 * 
 * Cracking the coding interview Q.8.3 (p.135).
 */

public class MagicIndex {
	private int[] arr;

	public MagicIndex(int[] arr) {
		this.arr = arr;
	}

	public int solve() {
		return search(0, arr.length - 1);
	}

	// search returns found magic index if exists, and -1 if no magic index is
	// found.
	private int search(int fromIdx, int toIdx) {
		if (fromIdx > toIdx) {
			return -1;
		}
		var midIdx = (fromIdx + toIdx) / 2;
		if (arr[midIdx] == midIdx) {
			return midIdx;
		}
		if (arr[midIdx] > midIdx) {
			return search(fromIdx, midIdx - 1);
		}
		if (arr[midIdx] < midIdx) {
			return search(midIdx + 1, toIdx);
		}
		return -1;
	}
}
