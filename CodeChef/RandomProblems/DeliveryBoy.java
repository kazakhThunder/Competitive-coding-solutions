import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DeliveryBoy {
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

	static void floydWarshall(int adMat[][], int N) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < adMat.length; j++) {
				for (int j2 = 0; j2 < adMat.length; j2++) {
					if (adMat[j][j2] > adMat[j][i] + adMat[i][j2]) {
						adMat[j][j2] = adMat[j][i] + adMat[i][j2];
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		StringBuilder ans = new StringBuilder();
		int N = sc.nextInt();
		int adMat[][] = new int[N][N];
		for (int i = 0; i < adMat.length; i++) {
			for (int j = 0; j < adMat.length; j++) {
				adMat[i][j] = sc.nextInt();
			}
		}
		int Q = sc.nextInt();
		floydWarshall(adMat, N);
		while (Q-- > 0) {
			int S = sc.nextInt();
			int G = sc.nextInt();
			int D = sc.nextInt();
			int via = adMat[S][G] + adMat[G][D];
			int dir = adMat[S][D];
			ans.append(via + " " + (via - dir) + "\n");
		}
		System.out.println(ans);
	}
}
