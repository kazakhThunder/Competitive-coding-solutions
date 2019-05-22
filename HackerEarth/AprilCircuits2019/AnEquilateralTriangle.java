import java.util.Scanner;

public class AnEquilateralTriangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), count = 0;
		sc.close();
		++n;
		for (int i = 2; i <= n; i++) {
			count += (((i * (i - 1)) / 2) * ((n - i) / 2));
		}
		System.out.println(count);
	}
}
