
import java.util.Arrays;
import java.util.Scanner;

public class ElecShop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int b, n, m;
		b = sc.nextInt();
		n = sc.nextInt();
		m = sc.nextInt();
		int arr[]=new int[n];
		for (int i = 0; i < n; i++) {
			arr[i]=sc.nextInt();
		}
		int arr2[]=new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i]=sc.nextInt();
		}
		int arr3[]=new int[n*m];
		int t=0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr3[t]=arr[i]+arr2[j];
				t++;
			}
		}
		int max=-1;
		for (int i = 0; i < arr3.length; i++) {
			if(arr3[i]>max&&arr3[i]<=b)
			{
				max=arr3[i];
			}
		}
		System.out.println(max);
	}
}