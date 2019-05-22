import java.util.Scanner;

public class gravityGuy {
	static char A[], B[];

	static int solver(char arr[], int i, int count) {
		if (i + 1 >= arr.length) {
			return count;
		} else if ((A[i + 1] == B[i + 1]) && (A[i + 1] == '#')) {
			return -1;
		} else if (arr[i + 1] != '#') {
			return solver(arr, i + 1, count);
		} else {
			if (arr == A) {
				arr = B;
			} else {
				arr = A;
			}
			return solver(arr, i + 1, count + 1);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder finAns = new StringBuilder();
		while (T-- > 0) {
			A = sc.next().toCharArray();
			B = sc.next().toCharArray();
			int ans = (Integer.min(solver(A, -1, 0), solver(B, -1, 0)));
			if (ans == -1) {
				finAns.append("No\n");
			} else {
				finAns.append("Yes\n" + ans + "\n");
			}
		}
		sc.close();
		System.out.println(finAns);
	}
}
