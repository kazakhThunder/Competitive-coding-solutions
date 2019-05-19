import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SubtreeRemoval {
	static class Reader {
		final private int BUFFER_SIZE = 1 << 16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer, bytesRead;

		public Reader() {
			din = new DataInputStream(System.in);
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public Reader(String file_name) throws IOException {
			din = new DataInputStream(new FileInputStream(file_name));
			buffer = new byte[BUFFER_SIZE];
			bufferPointer = bytesRead = 0;
		}

		public String readLine() throws IOException {
			byte[] buf = new byte[64]; // line length
			int cnt = 0, c;
			while ((c = read()) != -1) {
				if (c == '\n')
					break;
				buf[cnt++] = (byte) c;
			}
			return new String(buf, 0, cnt);
		}

		public int nextInt() throws IOException {
			int ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (neg)
				return -ret;
			return ret;
		}

		public long nextLong() throws IOException {
			long ret = 0;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();
			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');
			if (neg)
				return -ret;
			return ret;
		}

		public double nextDouble() throws IOException {
			double ret = 0, div = 1;
			byte c = read();
			while (c <= ' ')
				c = read();
			boolean neg = (c == '-');
			if (neg)
				c = read();

			do {
				ret = ret * 10 + c - '0';
			} while ((c = read()) >= '0' && c <= '9');

			if (c == '.') {
				while ((c = read()) >= '0' && c <= '9') {
					ret += (c - '0') / (div *= 10);
				}
			}

			if (neg)
				return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException {
			bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
			if (bytesRead == -1)
				buffer[0] = -1;
		}

		private byte read() throws IOException {
			if (bufferPointer == bytesRead)
				fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException {
			if (din == null)
				return;
			din.close();
		}
	}

	static ArrayList<Integer>[] tree;
	static int sum[];
	static boolean dp[];

	static Long dfs(int node, int X) {
		dp[node] = true;
		Long anSum = 0L;
		for (int i = 0; i < tree[node].size(); i++) {
			if (!dp[tree[node].get(i)]) {
				anSum += dfs(tree[node].get(i), X);
			}
		}
		return Long.max(anSum + sum[node], -X);
	}

	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		StringBuilder ans = new StringBuilder();
		Long T = sc.nextLong();
		while (T-- > 0) {
			int N = sc.nextInt();
			tree = new ArrayList[N];
			dp = new boolean[N];
			for (int i = 0; i < N; i++) {
				tree[i] = new ArrayList<Integer>();
			}
			sum = new int[N];
			int X = sc.nextInt();
			for (int i = 0; i < N; i++) {
				sum[i] = sc.nextInt();
			}
			for (int i = 0; i < N - 1; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				tree[u - 1].add(v - 1);
				tree[v - 1].add(u - 1);
			}
			ans.append(dfs(0, X) + "\n");
		}
		sc.close();
		System.out.print(ans);
	}
}
