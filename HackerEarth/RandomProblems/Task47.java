
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Task47 {
	static long ans(long n, ArrayList<Integer> arr, ArrayList<Integer> arL) {
		long prod = 1;
		for (int i = 0; i < arL.size(); i++) {
			prod *= arr.get(arL.get(i));
		}
		return (arL.size() % 2 == 0) ? (-(n / prod)) : (n / prod);
	}

	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		long T = sc.nextLong();
		StringBuilder finAns = new StringBuilder();
		ArrayList<Integer> arL = new ArrayList<Integer>();
		while (T-- > 0) {
			long n = sc.nextLong();
			int p = sc.nextInt();
			HashSet<Integer> arr = new HashSet<Integer>();
			for (int i = 0; i < p; i++) {
				arr.add(sc.nextInt());
			}
			ArrayList<Integer> arr1 = new ArrayList<Integer>();
			arr1.addAll(arr);
			p = arr1.size();
			long ans = 0;
			for (int i = 1; i < 1 << p; i++) {
				for (int j = 0; j < p; j++) {
					if (((1 << j) & i) > 0) {
						arL.add(j);
					}
				}
				ans += ans(n, arr1, arL);
				arL.clear();
			}
			finAns.append(ans + "\n");
		}
		sc.close();
		System.out.println(finAns);
	}
}
