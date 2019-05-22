package codeForcesPractice;

import java.util.Scanner;

public class IlyaAndQueries {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		String workP = sc.next();
		int size = workP.length();
		int q = sc.nextInt();
		int dp[] = new int[size];
		for (int i = 0; i < size - 1; i++) {
			if (workP.charAt(i + 1) == workP.charAt(i)) {
				dp[i] = 1;
			}
		}
		SegmentTree st = new SegmentTree(dp, size);
		for (int i = 0; i < q; i++) {
			int append = st.getSum(size, sc.nextInt() - 1, sc.nextInt() - 2);
			ans.append(append + "\n");
		}
		System.out.println(ans);
	}
}

class SegmentTree {
	int st[];

	SegmentTree(int arr[], int n) {

		int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));

		int max_size = 2 * (int) Math.pow(2, x) - 1;

		st = new int[max_size];

		constructSTUtil(arr, 0, n - 1, 0);
	}

	// A utility function to get the middle index from corner indexes.
	int getMid(int s, int e) {
		return s + (e - s) / 2;
	}

	int getSumUtil(int ss, int se, int qs, int qe, int si) {
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

	int getSum(int n, int qs, int qe) {
		// Check for erroneous input values
		if (qs < 0 || qe > n - 1) {
			System.out.println("Invalid Input");
			return -1;
		} else if (qs > qe) {
			return getSumUtil(0, n - 1, qs, qs, 0);
		}
		return getSumUtil(0, n - 1, qs, qe, 0);
	}

	int constructSTUtil(int arr[], int ss, int se, int si) {

		if (ss == se) {
			st[si] = arr[ss];
			return arr[ss];
		}

		int mid = getMid(ss, se);
		st[si] = constructSTUtil(arr, ss, mid, si * 2 + 1) + constructSTUtil(arr, mid + 1, se, si * 2 + 2);
		return st[si];
	}

}
