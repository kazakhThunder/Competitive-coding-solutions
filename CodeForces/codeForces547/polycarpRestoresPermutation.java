import java.util.Scanner;

public class polycarpRestoresPermutation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), flag = 0;
		int q[] = new int[n];
		int p[] = new int[n + 1];
		int freq[] = new int[n + 1];
		for (int i = 1; i < n; i++) {
			q[i] = sc.nextInt();
		}
		sc.close();
		if (q[1] < 0) {
			p[2] = 1;
			p[1] = 1 - q[1];
			freq[1]++;
			freq[p[1]]++;
			if ((1 == p[1]) || (p[1] > n)) {
				flag = 1;
			}
		} else {
			p[1] = 1;
			p[2] = 1 + q[1];
			freq[1]++;
			freq[p[2]]++;
			if ((1 == p[2]) || (p[2] > n)) {
				flag = 1;
			}
		}
		if (flag == 0) {
			for (int i = 3; i <= n; i++) {
				p[i] = q[i - 1] + p[i - 1];
				if ((p[i] > n) || (p[i] < 1) || (freq[p[i]] > 0)) {
					flag = 1;
					break;
				}
				freq[p[i]]++;
			}
			if (flag == 0) {
				for (int i = 1; i < p.length; i++) {
					System.out.print(p[i] + " ");
				}
			} else {
				for (int i = 1; i < p.length; i++) {
					System.out.print(p[i] + " ");
				}
				System.out.println(-1);
			}
		} else {
			for (int i = 1; i < p.length; i++) {
				System.out.print(p[i] + " ");
			}
			System.out.println(-1);
		}
	}
}
