import java.util.Scanner;

public class deputyChef {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int att[] = new int[N];
			int def[] = new int[N];
			for (int i = 0; i < N; i++) {
				att[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				def[i] = sc.nextInt();
			}
			int flag = 0;
			int max = -1;
			for (int i = 0; i < N; i++) {
				if (i == 0) {
					if (def[i] > att[i + 1] + att[N - 1] && def[i] > max) {
						max = def[i];
					}
				} else if (i == N - 1) {
					if (def[i] > att[i - 1] + att[0] && def[i] > max) {
						max = def[i];
					}
				} else {
					if (def[i] > att[i + 1] + att[i - 1] && def[i] > max) {
						max = def[i];
					}
				}
			}
			ans.append(max + "\n");
		}
		System.out.print(ans);
	}
}
