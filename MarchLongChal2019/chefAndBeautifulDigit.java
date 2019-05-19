import java.util.Arrays;
import java.util.Scanner;

class decInt implements Comparable<decInt> {
	char num;
	int ind;

	public int compareTo(decInt o) {
		return this.num - o.num;
	}
}

public class chefAndBeautifulDigit {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		StringBuilder finAns = new StringBuilder();
		while (T-- > 0) {
			char N[] = sc.next().toCharArray();
			StringBuilder ans = new StringBuilder();
			decInt arr[] = new decInt[N.length];
			for (int i = 0; i < N.length; i++) {
				arr[i] = new decInt();
				arr[i].ind = i;
				arr[i].num = N[i];
			}
			Arrays.sort(arr);
			char d = sc.next().charAt(0);
			int index = -1;
			for (int i = 0; i < arr.length; i++) {
				if (index < arr[i].ind && arr[i].num < d) {
					ans.append(arr[i].num);
					index = arr[i].ind;
				}
				if (arr[i].num >= d) {
					break;
				}
			}
			int diff = N.length - ans.length();
			while (diff-- > 0) {
				ans.append(d);
			}
			finAns.append(ans + "\n");
		}
		sc.close();
		System.out.println(finAns);
	}
}
