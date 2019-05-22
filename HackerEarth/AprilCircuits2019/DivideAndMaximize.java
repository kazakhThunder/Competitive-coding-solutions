import java.util.Scanner;

public class DivideAndMaximize {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int countCheckB = 1, countCheckC = 1;
		int A[] = new int[2 * N];
		int B[] = new int[N];
		int C[] = new int[N];
		for (int i = 0; i < 2 * N; i++) {
			A[i] = sc.nextInt();
		}
		int t = 0;
		for (int i = 1; i < 2 * N; i += 2) {
			if (countCheckC != K && countCheckB != K) {
				if (A[i] > A[i - 1]) {
					B[t] = i;
					C[t] = i + 1;
				} else {
					C[t] = i;
					B[t] = i + 1;
				}
			} else if (countCheckC == K) {
				int temp = C[t];
				C[t] = B[t];
				B[t] = temp;
				countCheckC = 1;
			} else {
				int temp = C[t];
				C[t] = B[t];
				B[t] = temp;
				countCheckB = 1;
			}
			++t;
			if (t > 0 && t < N && B[t - 1] + 1 == B[t]) {
				countCheckB++;
			} else if (t > 0 && t < N && C[t - 1] == C[t]) {
				countCheckC++;
			}
		}
		for (int i = 0; i < N; i++) {
			System.out.print(B[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < N; i++) {
			System.out.print(C[i] + " ");
		}
	}
}
