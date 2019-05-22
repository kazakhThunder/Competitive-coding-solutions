import java.math.BigInteger;
import java.util.Scanner;

public class gameOfStones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			BigInteger count = BigInteger.ZERO;
			int N = sc.nextInt();
			int P = sc.nextInt();
			int max = ((((N % 1) % 1) % 1) % N);
			for (int i = 1; i <= P; i++) {
				for (int j = 1; j <= P; j++) {
					for (int k = 1; k <= P; k++) {
						int temp = ((((N % i) % j) % k) % N);
						if (temp > max) {
							max = temp;
							count = BigInteger.ONE;
						} else if (temp == max) {
							count = count.add(BigInteger.ONE);
						}
					}
				}
			}
			ans.append(count + "\n");
		}
		sc.close();
		System.out.print(ans);
	}
}
