package codeForcesPractice;

import java.util.Scanner;

public class givenLengthAndSumOfDig {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder minNum = new StringBuilder();
		StringBuilder maxNum = new StringBuilder();
		int length = sc.nextInt();
		int sumOfDig = sc.nextInt();
		int sumOfDigCopy = sumOfDig;
		while (maxNum.length() < length) {
			if (sumOfDig > 9) {
				maxNum.append(9);
				sumOfDigCopy -= 9;
			} else if (sumOfDig > 0) {
				maxNum.append(sumOfDigCopy);
				sumOfDigCopy = 0;
			} else {
				maxNum.append(0);
			}
		}
		while (minNum.length() < length) {
			if (sumOfDig > 9) {
				minNum.append(9);
				sumOfDig -= 9;
			} else if (sumOfDig > 1 && minNum.length() != length - 1) {
				minNum.append(sumOfDig - 1);
				sumOfDig = 1;
			} else if (minNum.length() != length - 1) {
				minNum.append(sumOfDig);
			}
			else
			{
				minNum.append(0);
			}
		}
		while (minNum.length() < length) {
			if (minNum.length() == length - 1)
				minNum.append(1);
			else
				minNum.append(0);
		}
		minNum.reverse();
		System.out.println(minNum + " " + maxNum);
	}
}
