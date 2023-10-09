package hienpd.practice.algorithm.dp;

/**
 * 
 * Cracking the coding interview Q.8.1 (p.134).
 */
class TripleStep {
	public int maxWaysToRunUpStairs(int n) {
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		if (n == 3) {
			return 4;
		}

		var f = new int[n + 1];
		f[1] = 1;
		f[2] = 2;
		f[3] = 4;
		for (var i = 4; i <= n; i++) {
			f[i] = f[i - 3] + f[i - 2] + f[i - 1];
		}
		return f[n];
	}
}
