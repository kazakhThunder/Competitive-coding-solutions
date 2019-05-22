
package codeForcesPractice;

import java.util.Scanner;

public class DivisibiltyByEight {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		char temp[] = s.toCharArray();
		for (int i = 0; i < temp.length; i++) {
			for (int j = i + 1; j < temp.length; j++) {
				for (int j2 = j + 1; j2 < temp.length; j2++) {
					String anTemp = temp[i] + "" + temp[j] + "" + temp[j2];
					int yetAnTemp = Integer.parseInt(anTemp);
					if (yetAnTemp % 8 == 0) {
						System.out.println("YES\n" + yetAnTemp);
						return;
					}
				}
			}
		}
		for (int j = 0; j < temp.length; j++) {
			for (int j2 = j + 1; j2 < temp.length; j2++) {
				String anTemp = temp[j] + "" + temp[j2];
				int yetAnTemp = Integer.parseInt(anTemp);
				if (yetAnTemp % 8 == 0) {
					System.out.println("YES\n" + yetAnTemp);
					return;
				}
			}
		}
		for (int j2 = 0; j2 < temp.length; j2++) {
			String anTemp = temp[j2] + "";
			int yetAnTemp = Integer.parseInt(anTemp);
			if (yetAnTemp % 8 == 0) {
				System.out.println("YES\n" + yetAnTemp);
				return;
			}
		}
		System.out.println("NO");
	}
}
