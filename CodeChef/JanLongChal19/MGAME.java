import java.math.BigInteger;
import java.util.Scanner;

public class chefAndModuloGame {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			int N = sc.nextInt();
			int P = sc.nextInt();
			if (N > 2) {
				int M = (N - 1) / 2;
				int a = P - M;
				int b = P - N;
				BigInteger count = new BigInteger("0");
				count = count.add(new BigInteger(a * a + ""));
				count = count.add(new BigInteger(a * b + ""));
				count = count.add(new BigInteger(b * b + ""));
				ans.append(count + "\n");
			} else {
				int temp = (int) Math.pow(P, 3);
				ans.append(temp + "\n");
			}
		}
		sc.close();
		System.out.print(ans);
	}
}
