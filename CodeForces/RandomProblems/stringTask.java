package codeForcesPractice;

import java.util.Scanner;

public class stringTask {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder s = new StringBuilder(sc.next());
		String vowS = "aeiouy";
		String vowC = "AEIOUY";
		for (int i = 0; i < s.length(); i++) {
			int index = vowS.indexOf(s.charAt(i) + "");
			int index1 = vowC.indexOf(s.charAt(i) + "");
			if (index != -1 || index1 != -1) {
				s.deleteCharAt(i);
				i--;
			} else {
				if (s.charAt(i) >= 65 && s.charAt(i) <= 91) {
					s.replace(i, i + 1, "" + Character.toLowerCase(s.charAt(i)));
				}
				s.insert(i, '.');
				i++;
			}
		}

		System.out.println(s);
	}
}
