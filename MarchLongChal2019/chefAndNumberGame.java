import java.util.Scanner;

public class chefAndNumberGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			int pos = 0, neg = 0;
			int N = sc.nextInt();
			while (N-- > 0) {
				int temp = sc.nextInt();
				if (temp < 0) {
					neg++;
				} else {
					pos++;
				}
			}
			int big = (pos > neg) ? pos : neg;
			int small = (big == pos) ? neg : pos;
			if (big != 0 && small != 0) {
				ans.append(big + " " + small + "\n");
			} else {
				int app = (big == 0) ? small : big;
				ans.append(app + " " + app + "\n");
			}
		}
		System.out.println(ans);
	}
}
