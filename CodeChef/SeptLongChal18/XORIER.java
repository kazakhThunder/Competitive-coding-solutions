
import java.util.Scanner;

public class WarOfXORs {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			int freq[] = new int[1000001];
			int odd = 0, even = 0;
			long count = 0;
			for (int i = 0; i < arr.length; i++) {
				arr[i] = sc.nextInt();
				freq[arr[i]]++;
				if (arr[i] % 2 == 0) {
					even++;
				} else {
					odd++;
				}
			}
			for (int i = 0; i < N; i++) {
				if (arr[i] % 2 == 0) {
					count += even;
				} else {
					count += odd;
				}
				count -= ( freq[arr[i]]);
				count -= (freq[2 ^ arr[i]]);

			}
			count = count / 2;
			System.out.println(count);
		}
	}
}
