import java.util.Scanner;

public class BonAppetit {
	int mod(int a) {
		if (a < 0) {
			return -a;
		} else {
			return a;
		}
	}

	static void bonAppetit(int[] arr, int k, int b) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != k) {
				sum += arr[i];
			}
		}
		if (sum / 2 == b) {
			System.out.println("Bon Appetit");
		} else {
			System.out.println(b - (sum / 2));
		}
	}

	public static void main(String[] args) {
		int[] arr;
		int k, b,n;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		k=sc.nextInt();
		arr=new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i]=sc.nextInt();
		}
		b=sc.nextInt();
		bonAppetit(arr, k, b);
	}
}
