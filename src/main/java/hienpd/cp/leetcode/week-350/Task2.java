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

// Problem Statement:
// // https://leetcode.com/contest/weekly-contest-350/problems/total-distance-traveled/
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
			// int mainTank, additionalTank;
			// mainTank = in.nextInt();
			// additionalTank = in.nextInt();

			out.println(findValueOfPartition(null));
		}

		public int findValueOfPartition(int[] nums) {
			var list = convertToList(nums);
			Collections.sort(list);
			int value = list.get(list.size() - 1);
			for (int i = 0; i < list.size() - 1; i++) {
				var diff = list.get(i + 1) - list.get(i);
				if (value > diff) {
					value = diff;
				}
			}
			return value;
		}

		List<Integer> convertToList(int[] nums) {
			List<Integer> list = new ArrayList<Integer>();
			for (var num : nums) {
				list.add(num);
			}
			return list;
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
