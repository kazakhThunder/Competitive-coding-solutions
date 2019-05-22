package codeForcesPractice;

import java.util.Scanner;
import java.util.Stack;

public class trailingLoves {

	public static void main(String[] args) {
		long ans = Long.MAX_VALUE;
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		long b = sc.nextLong();
		long tempB = b;
		Stack<Long> factors = new Stack<Long>();
		long i = 2;
		while (i*i <= tempB) {
			if (tempB % i == 0) {
				tempB /= i;
				factors.push(i);
			} else {
				i++;
			}
		}
		if(tempB!=1) {
			factors.push(tempB);
		}
		while (!factors.isEmpty()) {
			long count = 1;
			long temp = factors.pop();
			while (!factors.isEmpty()) {
				long temp1 = factors.peek();
				if (temp1 != temp) {
					break;
				} else {
					count++;
					factors.pop();
				}
			}
			long anCount = 0;
			long adder = n / temp;
			i = 1;
			while (adder != 0) {
				anCount += adder;
				i++;
				adder = n / (long) Math.pow(temp, i);
			}
			ans = Long.min(ans, anCount / count);
		}
		sc.close();
		System.out.println(ans);
	}
}
