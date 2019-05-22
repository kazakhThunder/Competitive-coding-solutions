import java.util.Arrays;
import java.util.Scanner;

public class WetClothes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), m = sc.nextInt(), g = sc.nextInt(), count = 0;
		int rainTimes[], dryTimes[];
		rainTimes = new int[n];
		int temp = sc.nextInt();
		rainTimes[0] = 0;
		for (int i = 1; i < n; i++) {
			int temp2 = sc.nextInt();
			rainTimes[i] = temp2 - temp;
			temp = temp2;
		}
		Arrays.sort(rainTimes); 	
		dryTimes = new int[m];
		for (int i = 0; i < m; i++) {
			dryTimes[i] = sc.nextInt();
		}
		Arrays.sort(dryTimes);
		int maxRainTime = rainTimes[n - 1];
		for (int i = m - 1; i >= 0; i--) {
			if (dryTimes[i] <= maxRainTime) {
				count = i + 1;
				break;
			}
		}
		System.out.println(count);
	}
}
