
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

public class Fencing {
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
		StringBuilder ans = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt(), M = sc.nextInt(), K = sc.nextInt();
			long noOfFence = 0;
			HashSet<plant> hs = new HashSet<plant>(K);
			while (K-- > 0) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				hs.add(new plant(x, y));
			}
			Iterator<plant> it = hs.iterator();
			while (it.hasNext()) {
				plant temp = it.next();
				int x = temp.x, y = temp.y;
				if (x == 1) {
					noOfFence += 1;
				}
				if (x == M) {
					noOfFence += 1;
				}
				if (y == 1) {
					noOfFence += 1;
				}
				if (y == N) {
					noOfFence += 1;
				}
				if (x < M && !hs.contains(new plant(x + 1, y))) {
					noOfFence += 1;
				}
				if (y < N && !hs.contains(new plant(x, y + 1))) {
					noOfFence += 1;
				}
				if (x > 1 && !hs.contains(new plant(x - 1, y))) {
					noOfFence += 1;
				}
				if (y > 1 && !hs.contains(new plant(x, y - 1))) {
					noOfFence += 1;
				}
			}
			ans.append(noOfFence + "\n");
		}
		sc.close();
		ans.trimToSize();
		System.out.print(ans);
	}
}

class plant {
	int x, y;

	plant(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int hashCode() {
		int hashcode = 0;
		hashcode = x * 10;
		hashcode += y;
		return hashcode;
	}

	public boolean equals(Object obj) {
		if (obj instanceof plant) {
			plant pp = (plant) obj;
			return (pp.x == x && pp.y == y);
		} else {
			return false;
		}
	}
}
