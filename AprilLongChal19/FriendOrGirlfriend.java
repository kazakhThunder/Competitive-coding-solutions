
import java.util.ArrayList;
import java.util.Scanner;

public class FriendOrGirlfriend {

	static ArrayList<Integer> arL;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder finAns = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			long n = sc.nextLong();
			arL = new ArrayList<Integer>((int) n);
			String s = sc.next();
			char c = sc.next().charAt(0);
			arL.add(-1);
			for (int i = 0; i < n; i++) {
				if (s.charAt(i) == c) {
					arL.add(i);
				}
			}
			arL.add((int)n);
			arL.trimToSize();
			long ans = (n * (n + 1)) / 2;
			for (int i = 1; i < arL.size(); i++) {
				long temp = (arL.get(i) - arL.get(i - 1) - 1);
				ans -= (temp * (temp + 1)) / 2;

			}
			finAns.append(ans + "\n");
		}
		sc.close();
		System.out.println(finAns);
	}
}
