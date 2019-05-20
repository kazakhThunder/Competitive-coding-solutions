import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String eat = sc.nextLine();
		StringBuilder ans = new StringBuilder();
		while (T-- > 0) {
			int flag = 0;
			StringBuilder temp = new StringBuilder(sc.nextLine());
			int size = temp.length();
			int index = temp.indexOf("not");
			if (index >= 0) {
				if (index == 0) {
					if (index + 3 < size) {
						flag = (Character.isAlphabetic(temp.charAt(index + 3))) ? 0 : 1;
					//	System.out.println(1);
					} else {
					//	System.out.println(2);
						flag = 1;
					}
				} else if (index == size - 3) {
					if (index >= 1) {
						flag = (Character.isAlphabetic(temp.charAt(index - 1))) ? 0 : 1;
					//	System.out.println(3);
					} else {
						flag = 1;
			//			System.out.println(4);
					}
				} else {
					if (index > 0 && index + 3 < size) {
						if ((!Character.isAlphabetic(temp.charAt(index - 1))
								&& !Character.isAlphabetic(temp.charAt(index + 3)))) {
							flag = 1;
						//	System.out.println(5);
						}
					}
				}
			}

			if (flag == 1) {
				ans.append("Real Fancy\n");
			} else {
				ans.append("regularly fancy\n");
			}
		}
		sc.close();
		System.out.println(ans);
	}
}
