import java.util.Scanner;

public class HiHiAndCrazyBits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			Long N = sc.nextLong();
			int p = 0;
			for (int j = 0; j < 32; j++) {
				int helper = 1 << p;
				if ((helper & N) != helper) {
					System.out.println(helper + N);
					break;
				}
				p++;
			}
		}
		sc.close();
	}
}
