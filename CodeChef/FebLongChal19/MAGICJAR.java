import java.util.Scanner;

public class chefAndMagicalJars {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			int N = sc.nextInt();
			int arr[] = new int[N];
			long sum = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			ans.append(sum - N + 1 + "\n");
		}
		System.out.println(ans);
	}
}
