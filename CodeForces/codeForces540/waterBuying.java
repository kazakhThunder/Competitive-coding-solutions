package codeForces540;

import java.util.Scanner;

public class waterBuying {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while (q-- > 0) {
			float n = sc.nextFloat();
			float a = sc.nextFloat();
			float b = sc.nextFloat();
			float bPerL = b / 2;
			float aPerL = a;
			float lesPerL;
			float count = 0;
			float small, big;
			float les, more;
			if (bPerL > aPerL) {
				lesPerL = aPerL;
				small = a;
				big = b;
				les = 1;
				more = 2;
			} else {
				lesPerL = bPerL;
				small = b;
				big = a;
				les = 2;
				more = 1;
			}
			if (n % les == 0) {
				count = n * lesPerL;
			} else {
				n = n % les;
				System.out.println(les+" "+lesPerL+" "+big+" "+n);
				count = count + (((int) n / (int) les) * lesPerL);
				count = count + big;
			}
			System.out.println(count);
		}
	}
}
