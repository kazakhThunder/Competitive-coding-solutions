
package codeForcesPractice;

import java.util.Scanner;

public class RegistrationSystem {
	static StringBuilder ans = new StringBuilder();

	static node head = new node();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			String temp = sc.next();
			node.add(temp);
		}
		sc.close();
		System.out.print(ans.toString().trim());
	}

	static class node {
		boolean end;
		int printCount;
		node child[];

		node() {
			end = false;
			printCount = 0;
			child = new node[26];
		}

		static void add(String s) {
			node first = head;
			int flag = 0;
			for (int i = 0; i < s.length(); i++) {
				if (first.child[s.charAt(i) - 'a'] == null) {
					flag = 1;
					first.child[s.charAt(i) - 'a'] = new node();
				}
				first = first.child[s.charAt(i) - 'a'];
			}
			if (flag == 0 && first.end) {
				first.printCount++;
			} else {
				first.end = true;
			}
			if (first.printCount == 0) {
				ans.append("OK\n");
			} else {
				ans.append(s + first.printCount + "\n");
			}
		}

	}
}
