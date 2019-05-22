package snackDown2019OnlineRoundB;

import java.util.Scanner;

public class chefAndSequence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder("");
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int count = 0;
			for (int j = 0; j < N; j++) {
				int temp = sc.nextInt();
				count += (temp > 1) ? 1 : 0;
			}
			String appender = (count > K) ? "NO" : "YES";
			ans.append(appender + "\n");
		}
		System.out.println(ans);
		sc.close();
	}
}
