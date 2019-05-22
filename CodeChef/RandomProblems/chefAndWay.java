import java.util.Scanner;

public class chefAndWay {
	static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		double arr[] = new double[N];
		double dp[] = new double[N];
		for (int i = 0; i < N; i++) {
			dp[i] = Double.MAX_VALUE;
		}
		for (int i = 0; i < N; i++) {
			arr[i] = Math.log(sc.nextInt());
		}
		dp[0] = arr[0];
		for (int i = 1; i < dp.length; i++) {
			double min = dp[i - 1];
			for (int j = i - 1; (j >= 0) && (j >= i - K); j--) {
				if (dp[j] < min) {
					min = dp[j];
				}
			}
			dp[i] = arr[i] + min;
		}
		System.out.println(Math.ceil(Math.pow(Math.E, dp[N - 1]))%mod);
	}
}
