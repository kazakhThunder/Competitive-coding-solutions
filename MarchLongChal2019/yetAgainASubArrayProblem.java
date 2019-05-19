import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class yetAgainASubArrayProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			double K = sc.nextDouble();
			int arr[] = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int ans = 0;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < arr.length; i++) {
				for (int j = i; j < arr.length; j++) {
					temp.add(arr[j]);
					int m = (int) Math.ceil(K / temp.size());
					Collections.sort(temp);
					int X = temp.get(((int) K - 1) / m);
					int count = 0;
					for (int l = 0; l < temp.size(); l++) {
						if (temp.get(l) == X) {
							count++;
						}
						if (temp.get(l) > X) {
							 break;
						}
					}
					
					for (int l = 0; l < temp.size(); l++) {
						if (temp.get(l) == count) {
							ans++;
							break;
						}
					}
				}
				temp.clear();
			}
			System.out.println(ans);
		}
	}
}
