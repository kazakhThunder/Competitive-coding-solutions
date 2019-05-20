import java.util.Scanner;

public class Rectangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			boolean firstTest = (a == b || a == c || a == d) ? true : false;
			boolean secTest = false;
			if (a == b) {
				if (c == d) {
					secTest = true;
				}
			} else if (a == c) {
				if (b == d) {
					secTest = true;
				}
			} else if (a == d) {
				if (b == c) {
					secTest = true;
				}
			}
			if (firstTest && secTest) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
