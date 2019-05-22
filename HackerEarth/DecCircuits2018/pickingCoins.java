package hackerEarthDecCircuits2018;

import java.util.Scanner;

public class pickingCoins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long T = sc.nextLong();
		while (T-- > 0) {
			Long N = sc.nextLong();
			Long K = sc.nextLong();
			if (K == 1) {
				if (N % 2 == 0) {
					System.out.println("Bob");
				} else {
					System.out.println("Alice");
				}
			} else {
				int i = 1;
				while (N > 0) {
					Long toSub = (long) Math.pow(K, i);
					if (toSub > N) {
						System.out.println("Bob");
						break;
					} else {
						N -= toSub;
					}
					if (toSub > N) {
						System.out.println("Alice");
						break;
					} else {
						N -= toSub;
					}
					i++;
				}
			}
		}
	}
}
