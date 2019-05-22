import java.util.Scanner;

public class coloredBoots {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String eater = sc.nextLine();
		String l = sc.next();
		int lFreq[] = new int[27];
		String r = sc.next();
		int rFreq[] = new int[27];
		for (int i = 0; i < n; i++) {
			int temp = l.charAt(i) - 'a';
			int Ind = ((temp) >= 97) ? temp : 26;
			lFreq[Ind]++;
			temp = r.charAt(i) - 'a';
			Ind = ((temp) >= 97) ? temp : 26;
			rFreq[Ind]++;
		}
		
	}
}
