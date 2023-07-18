package hienpd.cp.leetcode.w353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Problem Statement:

public class Task2 {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		var in = new InputReader(inputStream);
		var out = new PrintWriter(outputStream);
		var t = new Task();
		t.solve(in, out);
		out.close();
	}

	static class Task {
		void solve(InputReader in, PrintWriter out) {

		}

		public int maximumJumps(int[] nums, int target) {
			int max = 0;
			int[] maxJumps = new int[nums.length];
			for (var j = nums.length - 2; j >= 0; j--) {
				maxJumps[j] = maxJumpsFrom(j, nums, target, maxJumps);
				if (maxJumps[j] > max) {
					max = maxJumps[j];
				}
			}
			return maxJumps[0];
		}

		public int maxJumpsFrom(int i, int[] nums, int target, int[] maxJumps) {
			int max = 0;
			for (var j = i + 1; j <= nums.length - 2; j++) {
				if (Math.abs(nums[j] - nums[i]) <= target && maxJumps[j] > 0) {
					var curJumps = 1 + maxJumps[j];
					if (max < curJumps) {
						max = curJumps;
					}
				}
			}
			if (max == 0 && Math.abs(nums[i] - nums[nums.length - 1]) <= target) {
				return 1;
			}
			return max;
		}
	}

	static class InputReader {
		private BufferedReader br;
		private StringTokenizer st;

		InputReader(InputStream is) {
			br = new BufferedReader(new InputStreamReader(is));
			st = null;
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}
	}
}
