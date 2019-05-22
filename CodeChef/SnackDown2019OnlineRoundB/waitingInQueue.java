package snackDown2019OnlineRoundB;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class waitingInQueue {
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

	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		StringBuilder ans = new StringBuilder("");
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int L = sc.nextInt();
			people temp[] = new people[M + N];
			for (int j = 0; j < M + N; j++) {
				temp[j] = new people();
				if (j < M) {
					temp[j].eTime = L * (j + 1);
				} else {
					temp[j].qTime = sc.nextInt();
				}
			}
			Arrays.sort(temp, M, M + N);
			for (int j = M; j < M + N; j++) {
				temp[j].eTime = L * (j + 1);
			}

			int min = temp[M].eTime - temp[M].qTime;
			for (int j = M; j < M + N; j++) {
				if ((temp[j].eTime - temp[j].qTime) < min) {
					min = temp[j].eTime - temp[j].qTime;
				}
				if (temp[j].qTime > K) {
					break;
				}
			}
			int t2 = temp[M + N - 1].eTime / L;
			int t = (t2 + 1) * L;
			for (int j = temp[M + N - 1].qTime + 1; j <= K; j++) {
				if (t - j < 0) {
					break;
				}
				if (t - j < min) {
					min = t - j;
				}
			}
			ans.append(min + "\n");

		}
		System.out.println(ans);
		sc.close();
	}
}

class people implements Comparable<people> {
	int qTime, eTime;

	people() {
		qTime = 0;
		eTime = 0;
	}

	@Override
	public int compareTo(people p) {
		// TODO Auto-generated method stub
		if (this.qTime > p.qTime) {
			return 1;
		} else if (this.qTime < p.qTime) {
			return -1;
		}
		return 0;
	}
}
