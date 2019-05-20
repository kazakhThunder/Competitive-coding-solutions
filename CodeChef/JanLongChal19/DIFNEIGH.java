import java.util.Scanner;

public class differentNeighbours {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			StringBuilder ans = new StringBuilder();
			if (M >= 3 && N >= 3 || M == N) {
				int temp[] = { 1, 2, 3, 4 };
				int temp1[] = { 3, 4, 1, 2 };
				int max = 0;
				for (int i = 0; i < N; i++) {
					if (i % 4 < 2) {
						for (int j = 0; j < M; j++) {
							int t = temp[j % 4];
							if (t > max) {
								max = t;
							}
							ans.append(t + " ");
						}
					} else {
						for (int j = 0; j < M; j++) {
							int t = temp1[j % 4];
							if (t > max) {
								max = t;
							}
							ans.append(t + " ");
						}
					}
					ans.append("\n");
				}
				System.out.print(max + "\n" + ans);
				ans.delete(0, ans.length());
			} else if (N == 1) {
				if (M == 2) {
					System.out.println("1\n1 1\n");
				} else {
					int arr[] = { 1, 2, 2, 1 };
					System.out.println(2);
					for (int i = 0; i < M; i++) {
						System.out.print(arr[i % 4] + " ");
					}
					System.out.println();
				}

			} else if (M == 1) {
				if (N != 2) {
					System.out.println(2);
					int temp[] = { 1, 2, 2, 1 };
					for (int i = 0; i < N; i++) {
						System.out.println(temp[i % 4]);
					}
				} else {
					System.out.println("1\n1\n1");
				}
			} else if (N == 2) {
				System.out.println(3);
				int temp[] = { 1, 2, 3 };
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < M; j++) {
						System.out.print(temp[j % 3] + " ");
					}
					System.out.println();
				}
			} else if (M == 2) {
				int max = 0;
				int ar1[] = { 1, 2 }, ar2[] = { 2, 1 }, ar3[] = { 3, 3 };
				for (int i = 0; i < N;) {
					for (int j = 0; j < 2 && i < N; j++) {
						if (ar1[j] > max) {
							max = ar1[j];
						}
						ans.append(ar1[j] + " ");
					}
					i++;
					ans.append("\n");
					for (int j = 0; j < 2 && i < N; j++) {

						ans.append(ar1[j] + " ");
					}
					i++;
					ans.append("\n");
					for (int j = 0; j < 2 && i < N; j++) {
						if (ar3[j] > max) {
							max = ar3[j];
						}
						ans.append(ar3[j] + " ");
					}
					i++;
					ans.append("\n");
					for (int j = 0; j < 2 && i < N; j++) {
						if (ar2[j] > max) {
							max = ar2[j];
						}
						ans.append(ar2[j] + " ");
					}
					i++;
					ans.append("\n");
					for (int j = 0; j < 2 && i < N; j++) {
						ans.append(ar2[j] + " ");
					}
					i++;
					ans.append("\n");
					for (int j = 0; j < 2 && i < N; j++) {
						ans.append(ar3[j] + " ");
					}
					i++;
					ans.append("\n");
				}
				String a=(ans.toString()).trim();
				System.out.println(max + "\n" + a);
			}
		}
	}
}
