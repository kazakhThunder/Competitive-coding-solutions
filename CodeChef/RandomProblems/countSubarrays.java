import java.util.Scanner;

public class countSubarrays {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder ans = new StringBuilder("");
		while (T-- > 0) {
			int N = sc.nextInt();
			long count = 1L;
			int arr[] = new int[N];
			long B[] = new long[N];
			B[0] = 1L;
			arr[0] = sc.nextInt();
			for (int i = 1; i < N; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] >= arr[i - 1]) {
					B[i] = B[i - 1] + 1;
				} else {
					B[i] = 1;
				}
				count += B[i];
			}
			ans.append(count + "\n");
		}
		sc.close();
		System.out.print(ans);
	}
}
