
import java.util.Scanner;

public class KFactorization {
	static int Kfact(int start, int[] arr, int N) {
		if (start >= arr.length) {
			if (N == 0) {
				return 1;
			} else {
				return 0;
			}
		}
		if (N == 0) {
			return 1;
		} else if (N < 0) {
			return 0;
		}
		return Kfact(start + 1, arr, N / arr[start]) + Kfact(start + 1, arr, N);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int arr[] = new int[K];
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(Kfact(0, arr, N));
	}
}
