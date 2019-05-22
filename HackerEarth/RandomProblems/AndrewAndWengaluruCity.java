import java.util.Scanner;

public class AndrewAndWengaluruCity {
	static int mod = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder finAns = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int ans = 0;
			int tempArray[] = new int[n];
			for (int i = 0; i < n; i++) {
				tempArray[i] = sc.nextInt();
			}
			for (int i = 1; i < n - 1; i++) {
				if (tempArray[i - 1] > tempArray[i] && tempArray[i + 1] > tempArray[i]) {
					ans = ((ans % mod) + ((Integer.max(tempArray[i - 1], tempArray[i + 1]) - tempArray[i]) % mod))
							% mod;
				}
			}
			finAns.append(ans + "\n");
		}
		System.out.println(finAns);
	}
}
