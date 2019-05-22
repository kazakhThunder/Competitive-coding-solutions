package snackDown2019OnlineRoundB;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class maxProduct {
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

	static String solver(int N, int K, int[] arr, int start, long n) {
		if (K == 0 || start >= arr.length) {
			if (N == 0) {
				return n%10000007 + "";
			} else {
				return "";
			}
		}
		return solver(N - arr[start], K - 1, arr, start + 1, n * (int) (Math.pow(arr[start], 2) - arr[start])) + "\n"
				+ solver(N, K, arr, start + 1, n);
	}

	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		StringBuilder ans = new StringBuilder("");
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int arsize=N-((K*(K-1))/2);
			int arr[] = new int[arsize];
			for (int j = 0; j < arsize; j++) {
				arr[j] = j + 1;
			}
			ArrayList<Integer> temp = new ArrayList<>();
			HashSet<Integer> temp2=new HashSet<Integer>();
			Scanner s=new Scanner((solver(N, K, arr, 0,1)));
			while(s.hasNextLine())
			{
				String line=s.nextLine();
				if(!line.equals("")) {
					temp2.add(Integer.parseInt(line));
				}
			}
	//		String[] workP = .trim().split(System.getProperty("line.seperator"));
			/*for (int j = 0; j < workP.length; j++) {
				if (workP[j] != "\n") {
					temp2.add(Integer.parseInt(workP[j]));
				}
			}*/
			temp.addAll(temp2);
			Collections.sort(temp);
			ans.append(temp.get(temp.size()-1) + "\n");
		}
		System.out.println(ans);
		sc.close();
	}
}
