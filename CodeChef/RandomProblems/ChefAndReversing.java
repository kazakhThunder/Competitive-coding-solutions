import java.util.Scanner;

public class ChefAndReversing {

	static int djikstra(int adMat[][], int V) {
		int dist[] = new int[V];
		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			visited[i] = false;
		}
		dist[0] = 0;
		for (int j = 0; j < V - 1; j++) {
			int min = Integer.MAX_VALUE;
			int u = -1;
			for (int i = 0; i < visited.length; i++) {
				if (dist[i] < min && !visited[i]) {
					u = i;
					min = dist[i];
				}
			}
			if (u == -1) {
				return Integer.MAX_VALUE;
			}
			visited[u] = true;
			for (int i = 0; i < V; i++) {
				if ((!visited[i]) && (dist[u] + adMat[u][i] < dist[i]) && (adMat[u][i] != Integer.MAX_VALUE)) {
					dist[i] = dist[u] + adMat[u][i];
				}
			}
		}
		return dist[V - 1];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int adMat[][] = new int[N][N];
		for (int i = 0; i < adMat.length; i++) {
			for (int j = 0; j < adMat.length; j++) {
				adMat[i][j] = Integer.MAX_VALUE;
			}
		}
		while (M-- > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			adMat[u - 1][v - 1] = 0;
			adMat[v-1][u-1]=(adMat[v-1][u-1]==0)?0:1;
		}
		int ans = djikstra(adMat, N);
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);

	}
}
