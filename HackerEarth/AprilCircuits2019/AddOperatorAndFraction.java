import java.util.ArrayList;
import java.util.Scanner;

class frac {
	int num, den;

	frac(int n, int d) {
		num = n;
		den = d;
	}
}

public class AddOperatorAndFraction {
	public static void main(String[] args) {
		ArrayList<frac> list = new ArrayList<frac>();
		list.add(new frac(0, 1));
		list.add(new frac(1, 2));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < list.size() - 1; j++) {
				frac temp = new frac((list.get(j).num + list.get(j + 1).num), (list.get(j).den + list.get(j + 1).den));
				if (temp.den <= i) {
					list.add(j + 1, temp);
				}
			}
		}
		System.out.println(list.get(k - 1).num + "/" + list.get(k - 1).den);
	}
}
