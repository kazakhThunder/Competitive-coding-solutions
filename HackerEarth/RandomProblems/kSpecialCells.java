import java.math.BigInteger;
import java.util.Scanner;

public class kSpecialCells {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int X[], Y[], P[];
			X = new int[K];
			Y = new int[K];
			P = new int[K];
			BigInteger count = BigInteger.ZERO;
			for (int i = 0; i < K; i++) {
				X[i] = sc.nextInt();
				Y[i] = sc.nextInt();
				P[i] = sc.nextInt();
				count = count.add(new BigInteger(P[i] + ""));
			}
			count = count.mod(new BigInteger("1000000007"));
			System.out.println(count);
		}
		sc.close();
	}
}
