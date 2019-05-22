
package codeForcesPractice;

import java.util.Scanner;

public class dubStep {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		String s = sc.next();
		for (int i = 0; i < s.length(); i++) {
			int t = i + 3;
			if (t >= s.length()) {
				t = s.length();
			}
			if ((t > i) && (s.substring(i, t).equals("WUB"))) {
				i = i + 2;
			} else {
				int temp = i + (s.substring(i).indexOf("WUB"));
				if (temp >= s.length()) {
					temp = s.length();
				} else if (temp == i - 1) {
					temp = s.length();
				}
				if (temp > i) {
					ans.append(s.substring(i, temp) + " ");
				}
				i = temp - 1;
			}
		}
		System.out.println(ans);
	}
}
