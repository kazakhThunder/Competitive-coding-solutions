package snackDown2019OnlineRoundB;

import java.io.IOException;
import java.util.Scanner;

public class chefAndSnackDown {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder ans = new StringBuilder("");
		int T = sc.nextInt();
		String cont = "2010,2015,2016,2017,2019";
		for (int i = 0; i < T; i++) {
			String temp = sc.next();
			boolean decide = cont.contains(temp);
			String appender = (decide) ? "HOSTED" : "NOT HOSTED";
			ans.append(appender + "\n");
		}
		System.out.println(ans);
		sc.close();
	}
}
