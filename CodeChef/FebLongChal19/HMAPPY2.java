import java.util.Scanner;

public class appyAndContest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder();
		int T = sc.nextInt();
		while (T-- > 0) {
			Long N = sc.nextLong(), temp = 0L;
			int A = sc.nextInt();
			int B = sc.nextInt();
			Long K = sc.nextLong();
			int big = (A > B) ? A : B;
			int small = ((A > B) ? B : A);
			if (big % small == 0) {
				temp = (N / small - N / big);
			} else {
				temp = ((N / small) + (N / big) - (2 * (N / (small * big))));
			}
			if(temp>=K)
			{
				ans.append("Win\n");
			}
			else
			{
				ans.append("Lose\n");
			}
		}
		System.out.print(ans);
	}
}
