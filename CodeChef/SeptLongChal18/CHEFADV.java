import java.util.Scanner;

public class ChefAndAdventures {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			long know = 1, pow = 1;
			long N = sc.nextInt();
			long M = sc.nextInt();
			long X = sc.nextInt();
			long Y = sc.nextInt();
			long toAddN = (N - know) / X;
			long toAddM = (M - pow) / Y;
			know = know + (toAddN * X);
			pow = pow + (toAddM * Y);
			if ((know == N - 1 && pow == M - 1) || (know == N && pow == M)) {
				System.out.println("Chefirnemo");
				continue;
			}
			if (N >= 2 && M >= 2) {
				know = 2;
				pow = 2;
				toAddN = (N - know) / X;
				toAddM = (M - pow) / Y;
				know = know + (toAddN * X);
				pow = pow + (toAddM * Y);
				if (know == N && pow == M) {
					System.out.println("Chefirnemo");
					continue;
				}
			}
			System.out.println("Pofik");
		}
	}
}
