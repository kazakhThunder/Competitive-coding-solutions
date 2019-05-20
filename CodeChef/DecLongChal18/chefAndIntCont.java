package codeChefDecChal2018;

import java.util.Scanner;

public class chefAndIntCont {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N, r;
		StringBuilder finAns = new StringBuilder();
		N = sc.nextInt();
		r = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int temp = sc.nextInt();
			boolean goodBoi = (temp >= r) ? true : false;
			String ans = (goodBoi) ? "Good boi\n" : "Bad boi\n";
			finAns.append(ans);
		}
		sc.close();
		System.out.println(finAns);
	}
}
