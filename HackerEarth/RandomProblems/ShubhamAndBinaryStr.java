import java.util.Scanner;

public class ShubhamAndBinaryStr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String ans="";
		for (int i = 0; i < T; i++) {
			int size = sc.nextInt();
			int count = 0;
			String bin = sc.next();
			char[] arr = bin.toCharArray();
			for (int j = 0; j < size; j++) {
				if (arr[j] == '0') {
					count++;
				}
			}
			ans=ans+count+"\n";
		}
		System.out.println(ans);
		sc.close();
	}
}
