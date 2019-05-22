import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class element implements Comparator<element> {
	int val;
	int freq;

	@Override
	public int compare(element o1, element o2) {
		return (o1.val - o2.val);
		// return 0;
	}
}

public class countThePermutations {

	static long fac[] = new long[100];

	static long fact(int n) {
		if (n <= 1) {
			return 1;
		} else if (fac[n] == 0) {
			for (int i = 2; i <= n; i++) {
				if (fac[i] == 0) {
					fac[i] = fac[i - 1] * i;
				}
			}
			return fac[n];
		} else {
			return fac[n];
		}
	}

	public static void main(String[] args) {
		fac[0] = 1;
		fac[1] = 1;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), count = 0;
		int max = 1000000007;
		int b[] = new int[n];
		ArrayList<element> a = new ArrayList<element>();
		for (int i = 0; i < n; i++) {
			element temp = new element();
			temp.val = sc.nextInt();
			temp.freq = 1;
			int flag = 0;
			for (int j = 0; j < a.size(); j++) {
				if (temp.val == (a.get(j)).val) {
					(a.get(j)).freq++;
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				a.add(temp);
			}
		}
		for (int i = 0; i < n; i++) {
			b[i] = sc.nextInt();
		}
	
		sc.close();
		long ans = 0;
		int flag = 0;
		for (int i = 0; i < n; i++) {
			int temp = b[i];
			for (int j = 0; j < a.size(); j++) {
				if (a.get(j).val < temp) {
					ans += (fact(n - (i + 1)) / fact((a.get(j).freq - 1)));
					for (int k = 0; k < a.size(); k++) {
						if (k != j) {
							ans = ans / (fact(a.get(k).freq));
						}
					}
				} else if (a.get(j).val == temp) {
					ans+=ans/(fact(n-(i+2))*fact(a.get(j).freq-1));
					for (int k = ; k < b.length - 1; k++) {
						
					}
				}
			}
			if (flag == 0) {
				break;
			}
		}
		System.out.println(ans);
	}
}
