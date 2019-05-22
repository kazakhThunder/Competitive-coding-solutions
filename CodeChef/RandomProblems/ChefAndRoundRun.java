import java.util.ArrayList;
import java.util.Scanner;

public class ChefAndRoundRun {
	static class Stack {
		ArrayList<Integer> arr;

		Stack() {
			arr = new ArrayList<Integer>();
		}

		void push(int data) {
			arr.add(data);
		}

		int pop() {
			int popped = arr.get(arr.size() - 1);
			arr.remove(arr.size() - 1);
			return popped;
		}

		boolean isEmp() {
			return (arr.size() == 0);
		}
	}

	static Stack stack = new Stack();
	static int count = 0;
	static int adMat[][];

	static int[][] transpose(int N) {
		int adMat1[][] = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (adMat[i][j] > 0) {
					adMat1[j][i] = 1;
				}
			}
		}
		return adMat1;
	}

	static void DFS(int v, boolean visited[], ArrayList<Integer> arL) {
		visited[v] = true;
		arL.add(v);
		for (int i = 0; i < adMat.length; i++) {
			if (!visited[i] && adMat[v][i] > 0) {
				DFS(i, visited, arL);
			}
		}
	}

	static void stackFill(int v, boolean visited[], int N) {
		visited[v] = true;
		for (int i = 0; i < N; i++) {
			if (adMat[v][i] > 0 && !visited[i]) {
				stackFill(i, visited, N);
			}
		}
		stack.push(v);
	}

	static int printSCCs(int N, boolean visited[]) {
		ArrayList<Integer> arL = new ArrayList<Integer>();
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				stackFill(i, visited, N);
			}
		}
		adMat = transpose(N);
		for (int i = 0; i < N; i++) {
			visited[i] = false;
		}
		int finalAns = 0;
		while (!stack.isEmp()) {
			int i = stack.pop();
			if (!visited[i]) {
				DFS(i, visited, arL);
				if (arL.size() == 1) {
					if (adMat[arL.get(0)][arL.get(0)] == 1) {
						finalAns++;
					}
				} else {
					finalAns += arL.size();
				}
				arL.clear();
			}
		}
		return finalAns;
	}

	public static void main(String[] args) {
		StringBuilder ans = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			adMat = new int[N][N];
			for (int i = 0; i < N; i++) {
				adMat[i][(i + sc.nextInt() + 1) % N] = 1;
			}
			boolean visited[] = new boolean[N];
			ans.append(printSCCs(N, visited) + "\n");
		}
		System.out.print(ans);
	}
}