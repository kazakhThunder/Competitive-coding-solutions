import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class chefAndSecretIngredients {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			int count[] = new int[26];
			int counter = 0;
			int N = sc.nextInt();
			for (int j = 0; j < N; j++) {
				char[] s = sc.next().toCharArray();
				HashSet<Character> hs = new HashSet<Character>();
				for (int i = 0; i < s.length; i++) {
					hs.add(s[i]);
				}
				ArrayList<Character> temp = new ArrayList<Character>(hs);
				for (int i = 0; i < temp.size(); i++) {
					if (count[temp.get(i) - 97] < j + 1) {
						count[temp.get(i) - 97]++;
					}
				}
			}
			for (int i = 0; i < 26; i++) {
				if (count[i] == N) {
					counter++;
				}
			}
			ans.append(counter + "\n");
		}
		sc.close();
		System.out.print(ans);
	}
}
