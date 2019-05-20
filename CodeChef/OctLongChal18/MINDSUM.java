import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

class node {
	long num;
	int count;

	node(long n, int c) {
		num = n;
		count = c;
	}
}

public class MindSum {
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

	static long digSum(long N) {
		long sum = 0;
		while (N > 0) {
			sum += N % 10;
			N /= 10;
		}
		return sum;
	}

	static node dp[] = new node[100000000];

	static void minSum(long D, int point, int count) {
		if (count == 15) {
			return;
		}
		dp[2 * point + 1] = new node(dp[point].num + D, dp[point].count + 1);
		dp[2 * point + 2] = new node(digSum(dp[point].num), dp[point].count + 1);
		minSum(D, 2 * point + 1, count + 1);
		minSum(D, 2 * point + 2, count + 1);
		
	}

	static node BFS() {
		int i = 0;
		long minNum = Long.MAX_VALUE;
		node min=dp[0];
		while (dp[i] != null) {
			if (dp[i].num < minNum) {
				minNum = dp[i].num;
				min = dp[i];
			}
			i++;
		}
		
		return min;
	}

	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		StringBuilder ans = new StringBuilder("");
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			long N = sc.nextLong();
			long D = sc.nextLong();
			dp[0]=new node(N,0);
			minSum(D,0,0);
			node an=BFS();
			System.out.println(an.num+" "+an.count);
		}
		System.out.println(ans);
		sc.close();
	}
}
