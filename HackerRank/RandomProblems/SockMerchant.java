import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class SockMerchant {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), sum = 0,ans=0;
		int[] arr = new int[n];
		HashSet<Integer> hs = new HashSet<>();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			hs.add(arr[i]);
		}
		sc.close();
		ArrayList<Integer> hs2 = new ArrayList<>();
		hs2.addAll(hs);
		for (int i = 0; i < hs.size(); i++) {
			sum=0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == hs2.get(i)) {
					sum++;
				}
			}
			ans=ans+sum/2;
		}
		System.out.println(ans);
		
	}
}
