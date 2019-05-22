import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

//Java Program to show segment tree operations like construction, 
//query and update 
class SegmentTree {
	long st[]; // The array that stores segment tree nodes

	/*
	 * Constructor to construct segment tree from given array. This constructor
	 * allocates memory for segment tree and calls constructSTUtil() to fill the
	 * allocated memory
	 */
	SegmentTree(long arr[], int n) {
		// Allocate memory for segment tree
		// Height of segment tree
		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

		// Maximum size of segment tree
		int max_size = 2 * (int) Math.pow(2, x) - 1;

		st = new long[max_size]; // Memory allocation

		constructSTUtil(arr, 0, n - 1, 0);
	}

	// A utility function to get the middle index from corner indexes.
	int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	/*
	 * A recursive function to get the sum of values in given range of the array.
	 * The following are parameters for this function.
	 * 
	 * st --> Pointer to segment tree si --> Index of current node in the segment
	 * tree. Initially 0 is passed as root is always at index 0 ss & se --> Starting
	 * and ending indexes of the segment represented by current node, i.e., st[si]
	 * qs & qe --> Starting and ending indexes of query range
	 */
	long getSumUtil(int ss, int se, int qs, int qe, int si) {
		// If segment of this node is a part of given range, then return
		// the sum of the segment
		if (qs <= ss && qe >= se)
			return st[si];

		// If segment of this node is outside the given range
		if (se < qs || ss > qe)
			return 0;

		// If a part of this segment overlaps with the given range
		int mid = getMid(ss, se);
		return getSumUtil(ss, mid, qs, qe, 2 * si + 1) + getSumUtil(mid + 1, se, qs, qe, 2 * si + 2);
	}

	/*
	 * A recursive function to update the nodes which have the given index in their
	 * range. The following are parameters st, si, ss and se are same as
	 * getSumUtil() i --> index of the element to be updated. This index is in input
	 * array. diff --> Value to be added to all nodes which have i in range
	 */
	void updateValueUtil(int ss, int se, int i, int diff, int si) {
		// Base Case: If the input index lies outside the range of
		// this segment
		if (i < ss || i > se)
			return;

		// If the input index is in range of this node, then update the
		// value of the node and its children
		st[si] = st[si] + diff;
		if (se != ss) {
			int mid = getMid(ss, se);
			updateValueUtil(ss, mid, i, diff, 2 * si + 1);
			updateValueUtil(mid + 1, se, i, diff, 2 * si + 2);
		}
	}

	// The function to update a value in input array and segment tree.
//It uses updateValueUtil() to update the value in segment tree 
	void updateValue(int arr[], int n, int i, int new_val) {
		// Check for erroneous input index
		if (i < 0 || i > n - 1) {
			System.out.println("Invalid Input");
			return;
		}

		// Get the difference between new value and old value
		int diff = new_val - arr[i];

		// Update the value in array
		arr[i] = new_val;

		// Update the values of nodes in segment tree
		updateValueUtil(0, n - 1, i, diff, 0);
	}

	// Return sum of elements in range from index qs (quey start) to
//qe (query end). It mainly uses getSumUtil() 
	long getSum(int n, int qs, int qe) {
		// Check for erroneous input values
		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("Invalid Input");
			return -1;
		}
		return getSumUtil(0, n - 1, qs, qe, 0);
	}

	// A recursive function that constructs Segment Tree for array[ss..se].
	// si is index of current node in segment tree st
	long constructSTUtil(long arr[], int ss, int se, int si) {
		// If there is one element in array, store it in current node of
		// segment tree and return
		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}

		// If there are more than one elements, then recur for left and
		// right subtrees and store the sum of values in this node
		int mid = getMid(ss, se);
		st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + constructSTUtil(arr, mid + 1, se, si * 2 + 2);
		return st[si];
	}

}
//This code is contributed by Ankur Narain Verma 

public class wayOut {

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
			int N = sc.nextInt();
			long H = sc.nextLong();
			long start[] = new long[N], end[] = new long[N];
			long row[] = new long[N];
			for (int i = 0; i < N; i++) {
				start[sc.nextInt()]++;
				end[sc.nextInt()]++;
			}
			row[0] = start[0];
			for (int i = 1; i < N; i++) {
				row[i] = start[i] + row[i - 1] - end[i - 1];
			}
			SegmentTree st = new SegmentTree(row, N);
			long max = -1L;
			for (int i = 0; i + H - 1 < N; i++) {
				long sum =st.getSum(N, i, (int)(i+H-1));
				if (max < sum) {
					max = sum;
				}
			}
			ans.append(((N * H) - max) + "\n");
		}
		System.out.println(ans);
	}
}
