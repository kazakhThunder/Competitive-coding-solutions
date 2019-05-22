import java.util.Scanner;

public class subArrays {

	static int kadane(int arr[], int N) {
		int sumTillI = 0, maxSum = 0, flag = 0, max = arr[0];
		for (int i = 0; i < N; i++) {
			sumTillI += arr[i];
			if (arr[i] > 0) {
				flag = 1;
			}
			if (arr[i] > max) {
				max = arr[i];
			}
			if (sumTillI < 0) {
				sumTillI = 0;
			}
			if (sumTillI > maxSum) {
				maxSum = sumTillI;
			}
		}
		if (flag == 0) {
			return max;
		} else {
			return maxSum;
		}
	}

	static int maxSubArrCount(int arr[], int N, int maxVal) {
		int sumTillI = 0, count = 0, maxCount = 0;
		for (int i = 0; i < N; i++) {
			sumTillI += arr[i];
			if (sumTillI < 0) {
				sumTillI = 0;
			}
			if (sumTillI == maxVal) {
				sumTillI = 0;
				count++;
			}
			if (arr[i] == maxVal) {
				maxCount++;
			}
		}
		if (maxVal > 0) {
			return count;
		} else {
			return maxCount;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int max = kadane(arr, N);
		if (max < 0) {
			System.out.println("0 0");
		} else {
			System.out.println(max + " " + maxSubArrCount(arr, N, max));
		}
	}
}