package hienpd.practice.algorithm.dp;

public class RecursiveMultiply {
	private int firstNum, secondNum;

	public RecursiveMultiply(int firstNum, int secondNum) {
		this.firstNum = firstNum;
		this.secondNum = secondNum;
	}

	public int solve() {
		return multiply(firstNum, secondNum);
	}

	private int multiply(int iFirstNum, int iSecondNum) {
		var smaller = (iFirstNum < iSecondNum) ? iFirstNum : iSecondNum;
		var bigger = (iFirstNum >= iSecondNum) ? iFirstNum : iSecondNum;
		if (smaller == 1) {
			return bigger;
		}
		var halfSmaller = smaller >> 1;
		var halfMultiply = multiply(bigger, halfSmaller);
		if (smaller % 2 != 0) {
			return halfMultiply + halfMultiply + bigger;
		}
		return halfMultiply + halfMultiply;
	}
}
