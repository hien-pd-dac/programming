import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TaskC {
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
		private Integer N;

		private List<PersonTossResult> persons;

		void solve(InputReader in, PrintWriter out) {
			N = in.nextInt();
			persons = new ArrayList<PersonTossResult>();
			for (var i = 0; i < N; i++) {
				Integer A = in.nextInt();
				Integer B = in.nextInt();
				persons.add(i, new PersonTossResult(i, A, B));
			}
			// out.println(persons);

			Collections.sort(persons);
			// out.println(persons);

			Collections.reverse(persons);

			// out.println(persons);
			for (var p : persons) {
				out.printf("%d ", p.getIndex() + 1);
			}

		}
	}

	static class PersonTossResult implements Comparable<PersonTossResult> {
		private Integer index;
		private Integer A, B;

		@Override
		public String toString() {
			return "PersonTossResult{" +
					"index=" + this.index +
					",A=" + this.A +
					",B=" + this.B +
					"}";
		}

		PersonTossResult(Integer index, Integer A, Integer B) {
			this.index = index;
			this.A = A;
			this.B = B;
		}

		@Override
		public int compareTo(PersonTossResult o) {
			var originResult = this.calSuccessRate();
			var otherResult = o.calSuccessRate();
			if (originResult == otherResult) {
				return -this.A.compareTo(o.A);
			}
			if (originResult < otherResult) {
				return -1;
			}
			return 1;
		}

		double calSuccessRate() {
			return (double) this.A / (this.A + this.B);
		}

		Integer getIndex() {
			return this.index;
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
