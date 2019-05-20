import java.util.Scanner;

public class ChefAndServes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int P1, P2, K;
			P1 = sc.nextInt();
			P2 = sc.nextInt();
			K = sc.nextInt();
			int check = (P1 + P2) / K;
			boolean even = check % 2 == 0;
			if (even) {
				System.out.println("CHEF");
			} else {
				System.out.println("COOK");
			}
		}
		sc.close();
	}
}