import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class TaskB {
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
		private Integer N, M;
		private List<String> C;
		private List<String> D;
		private List<Integer> P;

		void solve(InputReader in, PrintWriter out) {
			C = new ArrayList<String>();
			D = new ArrayList<String>();
			P = new ArrayList<Integer>();

			N = in.nextInt();
			M = in.nextInt();
			for (var i = 0; i < N; i++) {
				String c = in.next();
				C.add(i, c);
			}
			for (var i = 0; i < M; i++) {
				String d = in.next();
				D.add(i, d);
			}
			for (var i = 0; i < M + 1; i++) {
				Integer p = in.nextInt();
				P.add(i, p);
			}

			var CToDMap = new HashMap<String, Integer>();
			for (var i = 0; i < M; i++) {
				CToDMap.put(D.get(i), P.get(i + 1));
			}
			Integer totalPrice = 0;
			for (var i = 0; i < N; i++) {
				var price = CToDMap.get(C.get(i));
				if (price == null) {
					price = P.get(0);
				}
				totalPrice += price;
			}
			out.println(totalPrice);

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
