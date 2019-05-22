
package codeForcesPractice;

import java.util.Scanner;

public class InterestingDrink {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int n = sc.nextInt();
		int freq[] = new int[100001];
		int query[] = new int[100001];
		for (int i = 0; i < n; ++i) {
			++freq[sc.nextInt()];
		}
		int q = sc.nextInt();
		sc.close();
		query[0] = 0;
		for (int i = 1; i < 100001; ++i) {
			query[i] = freq[i] + query[i - 1];
		}
		for (int i = 0; i < q; i++) {
			int temp = sc.nextInt();
			if (temp < 100001)
				ans.append(query[temp] + "\n");
			else
				ans.append(query[100000] + "\n");
		}
		System.out.println(ans);
	}
}
