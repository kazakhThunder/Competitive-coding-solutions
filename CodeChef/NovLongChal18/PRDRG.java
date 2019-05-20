package codeChefNovChal2018;

import java.util.Scanner;

public class chefAndRidges {
	static String ratio(double n)
	{	int count=1;
		while(n!=(int)n) {
			n=n*2;
			count=count*2;
		}
		return (int)n+" "+count;
	}
	static double solver(int n) {
		if (n == 1) {
			return 0.5;
		} else if (n == 2) {
			return 0.25;
		}
		return (solver(n - 1) + solver(n - 2)) / 2;
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for (int i = 0; i < T; i++) {
			System.out.print(ratio(solver(sc.nextInt()))+" ");
		}
		sc.close();
	}
}
