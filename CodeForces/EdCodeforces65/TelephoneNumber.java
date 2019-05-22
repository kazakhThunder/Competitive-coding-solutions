import java.util.Scanner;

public class TelephoneNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			int n = sc.nextInt();
			String temp = sc.next();
			if (n < 11) {
				ans.append("NO\n");
			} else if (n == 11) {
				ans.append((temp.charAt(0) == '8') ? "YES\n" : "NO\n");
			} else {
				int flag = 0;
				for (int i = 0; i <= n - 11; i++) {
					if (temp.charAt(i) == '8') {
						ans.append("YES\n");
						flag = 1;
						break;
					}
				}
				ans.append((flag == 0) ? "NO\n" : "");
			}
		}
		System.out.print(ans);
	}
}
