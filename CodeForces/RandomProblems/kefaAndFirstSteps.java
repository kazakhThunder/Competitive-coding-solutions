package codeForcesPractice;

import java.util.Scanner;

public class kefaAndFirstSteps {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), count = 1;
		int arr[] = new int[n], arr2[] = new int[n];
		arr2[0] = 1;
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			if (arr[i + 1] >= arr[i]) {
				count++;
			} else {
				count = 1;
			}
			if (count > arr2[i]) {
				arr2[i + 1] = count;
			} else {
				arr2[i + 1] = arr2[i];
			}
		}
		System.out.println(arr2[n - 1]);
	}
}
