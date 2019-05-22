package codeForcesPractice;

import java.util.ArrayList;
import java.util.Scanner;

public class IncreasingSubsequenceE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> SubSeq = new ArrayList<Integer>();
		StringBuilder ans = new StringBuilder();
		int i = 0, j = N - 1;
		while (true) {
			int temp = (!SubSeq.isEmpty()) ? SubSeq.get(SubSeq.size() - 1) : 0;
			if(i>j) {
				break;
			}
			if(i==j&&arr[i]>temp) {
				ans.append("L");
				break;
			}
		
			if (temp < arr[i] && arr[i] < arr[j]) {
				SubSeq.add(arr[i]);
				ans.append("L");
				i++;
			} else if (temp < arr[j] && arr[j] < arr[i]) {
				SubSeq.add(arr[j]);
				ans.append("R");
				j--;
			} else if (temp > arr[i] && arr[j] > arr[i] && arr[j] > temp) {
				SubSeq.add(arr[j]);
				ans.append("R");
				j--;
			} else if (temp > arr[j] && arr[i] > arr[j] && arr[i] > temp) {
				SubSeq.add(arr[i]);
				ans.append("L");
				i++;
			} else {
				break;
			}
		}
		System.out.print(ans.length() + "\n" + ans);
	}
}
