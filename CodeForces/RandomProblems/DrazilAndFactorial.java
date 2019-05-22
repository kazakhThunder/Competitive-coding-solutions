//package codeForcesPractice;

import java.util.Arrays;
import java.util.Scanner;

public class DrazilAndFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String ans = "";
		String workP = sc.next();
		for (int i = 0; i < n; i++) {
			char temp = workP.charAt(i);
			if (temp == '4') {
				ans += "322";
			} else if (temp == '6') {
				ans += "53";
			} else if (temp == '8') {
				ans += "7222";
			} else if (temp == '9') {
				ans += "7332";
			} else if (temp != '1' && temp != '0') {
				ans += temp;
			}
		}
		char finalAns[] = ans.toCharArray();
		Arrays.sort(finalAns);
		for (int i = finalAns.length - 1; i >= 0; i--) {
			System.out.print(finalAns[i]);
		}
	}
}
