import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskA {
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
		// private properties
		private int[] arr;

		void solve(InputReader in, PrintWriter out) {
			String result = "Yes";
			arr = new int[8];
			for (var i = 0; i < arr.length; i++) {
				arr[i] = in.nextInt();
			}
			for (var i = 0; i < arr.length; i++) {
				if (i < (arr.length - 1)) {
					if (arr[i] > arr[i + 1]) {
						result = "No";
						break;
					}
				}
				if (arr[i] < 100 || arr[i] > 675) {
					result = "No";
					break;
				}
				if (arr[i] % 25 != 0) {
					result = "No";
					break;
				}
			}
			out.println(result);
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
