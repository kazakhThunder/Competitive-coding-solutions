import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DoesItDivide {
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

	static boolean isPrime(int n) {
		for (int j = 2; j < n; j++) {
			if (n % j == 0) {
				return false;
			}
		}
		return true;
	}

	boolean isprime(int n) {
		if (n == 2)
			return true;
		if (n == 3)
			return true;
		if (n % 2 == 0)
			return false;
		if (n % 3 == 0)
			return false;
		int i = 5;
		int w = 2;
		while (i * i <= n) {
			if (n % i == 0)
				return false;
			i += w;
			w = 6 - w;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		StringBuilder finans = new StringBuilder();
		Reader sc = new Reader();
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			if (n % 2 == 1) {
				finans.append("YES\n");
			} else {
				if (isPrime(n + 1)) {
					finans.append("NO\n");
				} else {
					finans.append("YES\n");
				}
			}
		}
		System.out.print(finans);
	}
}
