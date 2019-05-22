package codeForcesPractice;

import java.util.Scanner;

public class lecture {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		String lang1[] = new String[m];
		String lang2[] = new String[m];
		for (int i = 0; i < m; i++) {
			lang1[i] = sc.next();
			lang2[i] = sc.next();
		}
		String eat = sc.nextLine();
		String arr[] = sc.nextLine().split(" ");
		for (int i = 0; i < m; i++) {
			String temp = (lang1[i].length() > lang2[i].length()) ? lang2[i] : lang1[i];
			for (int j = 0; j < arr.length; j++) {
				if (arr[j].equals(lang1[i])) {
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
