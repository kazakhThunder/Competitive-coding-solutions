import java.util.Scanner;

public class maxScore {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			long sum = 0;
			int arr[][] = new int[N][N];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int flag = 0;
			long ax = Long.MAX_VALUE;
			for (int i = N - 1; i >= 0; i--) {
				int max = 0;
				for (int j = 0; j < arr.length; j++) {
					if (arr[i][j] > max && ax > arr[i][j]) {
						max = arr[i][j];
					}
				}
				if (max == 0) {
					System.out.println(-1);
					flag = 1;
					break;
				}
				ax = max;
				sum += max;
			}
			if (flag != 1) {
				System.out.println(sum);
			}
		}
	}
}
