
import java.util.Scanner;

public class ChefAndOperations {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ans = "";
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N=sc.nextInt();
			int arrA[]=new int[N];
			int arrB[]=new int[N];
			for (int j = 0; j < N; j++) {
				arrA[j]=sc.nextInt();
			}
			for (int j = 0; j < N; j++) {
				arrB[j]=sc.nextInt();
			}
			for (int j = 0; j < N; j++) {
				arrB[j]=arrB[j]=arrA[j];
			}
			
		}
		sc.close();
	}
}