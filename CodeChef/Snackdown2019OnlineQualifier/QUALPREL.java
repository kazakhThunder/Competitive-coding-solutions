import java.util.Arrays;
import java.util.Scanner;

public class QUALPREL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String ans = "";
		for (int i = 0; i < T; i++) {
			int N, K, minScore, count = 0;
			N = sc.nextInt();
			K = sc.nextInt();
			int arr[] = new int[N];
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
			}
			Arrays.sort(arr);
			minScore = arr[N-K];
			for (int j = N-1; j >=0; j--) {
				if (arr[j] >= minScore) {
					count++;
				} else {
					break;
				}
			}
			ans = ans + count + "\n";
		}
		System.out.println(ans);
	}
}
