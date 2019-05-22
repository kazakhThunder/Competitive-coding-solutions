
import java.util.Scanner;

public class SherlockAndSquares {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = "";
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int a, b;
			a = sc.nextInt();
			b = sc.nextInt();
			double aRoot = Math.sqrt(a);
			int aRootCast = (int) aRoot;
			int bRoot = (int) Math.sqrt(b);
			if (aRoot != (int) aRoot) {
				aRootCast++;
			}
			ans = ans + (bRoot - aRootCast + 1);
		}
		sc.close();
		System.out.println(ans);
	}
}