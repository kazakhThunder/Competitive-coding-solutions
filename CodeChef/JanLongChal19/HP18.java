import java.util.Scanner;

public class luckyNumberGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			int N = sc.nextInt();
			int bobLucky = sc.nextInt();
			int aliceLucky = sc.nextInt();
			int aliceCount = 0, bobCount = 0, abCount = 0;
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				if (arr[i] % aliceLucky == 0 && arr[i] % bobLucky == 0) {
					abCount++;
				} else if (arr[i] % aliceLucky == 0) {
					aliceCount++;
				} else if (arr[i] % bobLucky == 0) {
					bobCount++;
				}
			}
			if (aliceLucky == bobLucky) {
				ans.append("BOB\n");
			}
			else if (bobCount > aliceCount) {
				ans.append("BOB\n");
			} else if (bobCount < aliceCount) {
				ans.append("ALICE\n");
			} else {
				if (abCount > 0) {
					ans.append("BOB\n");
				} else {
					ans.append("ALICE\n");
				}
			}
		}
		System.out.print(ans);
	}
}
