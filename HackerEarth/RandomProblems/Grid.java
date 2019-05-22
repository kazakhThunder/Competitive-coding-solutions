import java.util.Scanner;

class block {
	int val, index;
}

public class Grid {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int Q = sc.nextInt();
		int k=0;
		block temp[][] = new block[N][M];
		int adMat[][] = new int[N * N][M * M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				String anTemp = sc.next();
				temp[i][j].val=("O".equals(anTemp))?1:0;
				temp[i][j].index=k++;
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (temp[i][j].val == 1) {
					if (i + 1 < N) {
						adMat[temp[i][j].index][i+1]
					}
				}
			}
		}
	}
}
