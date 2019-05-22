
import java.util.Scanner;

public class prepForWomDay {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int rem[] = new int[k];
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			rem[temp % k]++;
		}
		int count = rem[0] / 2;
		if (k % 2 == 0)
			count += rem[k / 2] / 2;
		for (int i = 1; i < (k + 1) / 2; i++) {
			int anothTemp = k - i;
			count += Integer.min(rem[i], rem[anothTemp]);
		}
		System.out.println(count * 2);
	}
}
