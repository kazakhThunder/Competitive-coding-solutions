import java.util.Scanner;

public class ReduceToOne {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder finAns = new StringBuilder();
		long T = sc.nextLong();
		long dp[] = new long[1000001];
		dp[1] = 1;
		for (int i = 2; i < 1000001; i++) {
		dp[i]=dp[i-1]+i+(dp[i-1]*i);
		dp[i]=dp[i]%1000000007;
		}
		while (T-- > 0) {
			finAns.append(dp[sc.nextInt()] + "\n");
		}
		sc.close();
		System.out.println(finAns);
	}

}
