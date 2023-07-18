package hienpd.cp.leetcode.w353;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

// Problem Statement:

public class Task1 {
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
			int mainTank, additionalTank;
			mainTank = in.nextInt();
			additionalTank = in.nextInt();

			out.println(distanceTraveled(mainTank, additionalTank));
		}

		public int distanceTraveled(int mainTank, int additionalTank) {
			if (mainTank < 5) {
				return mainTank * 10;
			}
			if (additionalTank >= 1) {
				mainTank += 1;
				return 10 * 5 + distanceTraveled(mainTank - 5, additionalTank - 1);
			}
			return 10 * 5 + distanceTraveled(mainTank - 5, additionalTank);
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
