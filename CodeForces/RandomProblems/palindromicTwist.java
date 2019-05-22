package codeForcesPractice;

import java.util.Scanner;

public class palindromicTwist {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			String s = sc.next();
			int fin = n - 1, count = 0;
			for (int i = 0; i <= fin / 2; i++) {
				int a=Math.abs((s.charAt(i) - s.charAt(fin - i)));
				if ( a== 2||a==0) {
			//		System.out.println(s.charAt(i) + " " + s.charAt(fin - i));
					count++;
				}
			}
			System.out.println((count == ((fin / 2) + 1)) ? "YES" : "NO");
		}
	}
}
