package codeForcesPractice;

import java.util.Scanner;

public class epicGame {
	static int eulerGCD(int a, int b) {
		if (a == 0 || b == 0) {
			return (a == 0) ? b : a;
		} else {
			int big = (a > b) ? a : b;
			int small = (big == a) ? b : a;
			return eulerGCD(small, big % small);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		int n=sc.nextInt();
		while(true)
		{
			
		}
	}
}
