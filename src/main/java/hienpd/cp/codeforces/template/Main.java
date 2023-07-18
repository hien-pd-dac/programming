package hienpd.cp.codeforces.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		// try {
		// InputStream inputStream = new FileInputStream("Cinput.txt");
		// OutputStream outputStream = System.out;
		// var in = new InputReader(inputStream);
		// var out = new PrintWriter(outputStream);
		// var t = new Task();
		// t.solve(in, out);
		// out.close();
		// } catch (IOException e) {
		// e.printStackTrace();
		// return;
		// }
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		var in = new InputReader(inputStream);
		var out = new PrintWriter(outputStream);
		var t = new Task();
		t.solve(in, out);
		out.close();
	}

	static class Task {
		// private properties
		private int testCases;
		private int[] arr;

		void solve(InputReader in, PrintWriter out) {
			testCases = in.nextInt();
			arr = new int[testCases];
			for (var i = 0; i < testCases; i++) {
				arr[i] = in.nextInt();
			}
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
