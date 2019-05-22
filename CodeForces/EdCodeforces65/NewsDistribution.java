
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class NewsDistribution {
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

	static int rk[];
	static int parent[];

	static int parent(int node) {
		return (node == parent[node]) ? node : (parent[node] = parent(parent[node]));
	}

	static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}

	static void unite(int a, int b) {
		a = parent(a);
		b = parent(b);
		if (a == b)
			return;
		if (rk[a] < rk[b])
			swap(a, b);
		parent[b] = a;
		rk[a] += rk[b];
	}

	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		StringBuilder ans = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		parent = new int[n];
		rk = new int[n];
		for (int i = 0; i < n; i++) {
			rk[i] = 1;
			parent[i] = i;
		}
		while (m-- > 0) {
			int k = sc.nextInt();
			int last = -1;
			while (k-- > 0) {
				int temp = sc.nextInt() - 1;
				if (last != -1) {
					unite(temp, last);
				}
				last = temp;
			}
		}
		sc.close();
		for (int i = 0; i < n; i++) {
			ans.append(rk[parent(i)] + " ");
		}
		System.out.print(ans);
	}
}