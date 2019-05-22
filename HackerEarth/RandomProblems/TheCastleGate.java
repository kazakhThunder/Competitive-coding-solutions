import java.util.Scanner;

public class TheCastleGate {
	static int Counter(int N) {
		int count = 0;
		for (int i = 1; i <= N - 1; i++) {
			for (int j = i + 1; j <= N; j++) {
				if ((i ^ j) <= N) {
					count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int P = sc.nextInt();
			System.out.println(Counter(P));
		}
		sc.close();
	}
}