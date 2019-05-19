import java.util.Scanner;

public class chefGotRecipes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			long count = 0;
			int freq[] = new int[32];
			for (int i = 0; i < N; i++) {
				StringBuilder temp = new StringBuilder(sc.next());
				StringBuilder vowCount = new StringBuilder("00000");
				for (int j = 0; j < temp.length(); j++) {
					switch (temp.charAt(j)) {
					case 'a':
						vowCount.replace(0, 1, "1");
						break;
					case 'e':
						vowCount.replace(1, 2, "1");
						break;
					case 'i':
						vowCount.replace(2, 3, "1");
						break;
					case 'o':
						vowCount.replace(3, 4, "1");
						break;
					case 'u':
						vowCount.replace(4, 5, "1");
						break;
					default:
						break;
					}
				}
				freq[Integer.parseInt(vowCount.toString(), 2)]++;
			}
			for (int i = 1; i < 32; i++) {
				for (int j = 1; j < 32; j++) {
					if ((i | j) == 31) {
						if (i == j) {
							count += ((freq[i]) * (freq[j] - 1));
						} else {
							count += freq[i] * freq[j];
						}
					}
				}
			}
			ans.append((count / 2) + "\n");
		}
		System.out.println(ans);
	}
}