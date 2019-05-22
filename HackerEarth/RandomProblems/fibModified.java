import java.util.Scanner;

public class fibModified {
	static int fibModify(int t1, int t2, int n) {
		if (n == t1) {
			return t1;
		} else if (n == t2) {
			return t2;
		}
		return fibModify(t1, t2, n);
	}

	public static void main(String[] args) {
		int t1, t2, n;
		Scanner sc = new Scanner(System.in);
		t1 = sc.nextInt();
		t2 = sc.nextInt();
		n = sc.nextInt();
		System.out.println(fibModify(t1, t2, n));
		sc.close();
	}
}
