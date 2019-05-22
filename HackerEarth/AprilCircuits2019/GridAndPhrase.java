import java.util.Scanner;

public class GridAndPhrase {
	static char matrix[][];
	static int check(int n, int m, int i, int j) {
		int count = 0;
		String checker = "aba";
		if (i + 3 < n) {
			String s = matrix[i + 1][j] + "" + matrix[i + 2][j] + matrix[i + 3][j];
			count += (s.equals(checker)) ? 1 : 0;
		}
		if (i + 3 < n && j + 3 < m) {
			String s = matrix[i + 1][j + 1] + "" + matrix[i + 2][j + 2] + matrix[i + 3][j + 3];
			count += (s.equals(checker)) ? 1 : 0;
		}
		if (j + 3 < m) {
			String s = matrix[i][j + 1] + "" + matrix[i][j + 2] + matrix[i][j + 3];
			count += (s.equals(checker)) ? 1 : 0;
		}
		if (i >= 3 && j + 3 < m) {
			String s = matrix[i - 1][j + 1] + "" + matrix[i - 2][j + 2] + matrix[i - 3][j + 3];
			count += (s.equals(checker)) ? 1 : 0;
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n, m, count = 0;
		n = sc.nextInt();
		m = sc.nextInt();
		matrix = new char[n][m];
		for (int i = 0; i < n; i++) {
			String temp = sc.next();
			for (int j = 0; j < m; j++) {
				matrix[i][j] = temp.charAt(j);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[i][j] == 's') {
					count += check(n, m, i, j);
				}
			}
		}
		System.out.println(count);
	}
}
