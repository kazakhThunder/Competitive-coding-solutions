import java.util.Scanner;

public class chefAndRemissness {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			System.out.println(Integer.max(A, B) + " " + (A + B));
		}
	}
}
