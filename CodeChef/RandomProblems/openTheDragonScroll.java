import java.util.Scanner;

public class openTheDragonScroll {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int A = sc.nextInt();
			int B = sc.nextInt();
			int aBitCount = Integer.bitCount(A);
			int bBitCount = Integer.bitCount(B);
			int ans = 0, numOfTime = (aBitCount + bBitCount), i;
			for (i = N - 1; i >= 0; i--) {
				if (numOfTime > 0) {
					ans += Math.pow(2, i);
					numOfTime--;
				}
			}
			i = 0;
			while (numOfTime > 0 && i < N) {
				ans -= Math.pow(2, i);
				i++;
				numOfTime--;
			}
			System.out.println(ans);
		}
	}
}
