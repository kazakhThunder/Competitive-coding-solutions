import java.util.Scanner;

public class MonksAndBox {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int arr[], counter[];
			arr = new int[N];
			counter = new int[32];
			for (int j = 0; j < N; j++) {
				arr[j] = sc.nextInt();
				int p = 0;
				for (int j2 = 0; j2 < 32; j2++) {
					int helper = 1 << p;
					if ((helper & arr[j]) == helper) {
						counter[j2]++;
					}
					p++;
				}
			}
			int max = counter[0];
			int maxIndex = 0;
			for (int j = 0; j < 32; j++) {
				if (counter[j] > max) {
					max = counter[j];
					maxIndex = j;
				}
			}
			System.out.println(maxIndex);
		}
		sc.close();
	}
}
