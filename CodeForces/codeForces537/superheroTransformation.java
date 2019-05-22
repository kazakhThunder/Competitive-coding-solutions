import java.util.Scanner;

public class superheroTransformation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char a[] = sc.next().toCharArray();
		char b[] = sc.next().toCharArray();
		String vow = "aeiou";
		int count = 0, flag = 0;
		for (int i = 0; i < b.length; i++) {
			if (a.length != b.length) {
				flag = 1;
				break;
			}
			if (vow.contains(a[i] + "") && vow.contains(b[i] + "")) {
				count++;
			} else if (!vow.contains(a[i] + "") && !vow.contains(b[i] + "")) {
				count++;
			}
		}
		if (flag == 1) {
			System.out.println("No");
		} else if (count == b.length) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}
}
