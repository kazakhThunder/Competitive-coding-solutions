import java.util.Arrays;
import java.util.Scanner;

class frog implements Comparable<frog> {
	int left, right, index, pos;

	frog(int i, int p) {
		index = i;
		pos = left = right = p;
	}

	@Override
	public int compareTo(frog o) {
		return this.pos - o.pos;
	}
}

public class chefsAndFrogs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt(), P = sc.nextInt();
		frog foo[] = new frog[N];
		for (int i = 0; i < N; i++) {
			foo[i] = new frog(i, sc.nextInt());
		}
		Arrays.sort(foo);
		int j = N - 2;
		for (int i = 1; i < N; i++) {
			if (foo[i].pos - foo[i - 1].pos <= K) {
				foo[i].left = foo[i - 1].left;
			}
			if (foo[j + 1].pos - foo[j].pos <= K) {
				foo[j].right = foo[j + 1].right;
			}
			j--;
		}
		frog foo2[] = new frog[N];
		for (int i = 0; i < foo.length; i++) {
			foo2[foo[i].index] = foo[i];
		}
		
		for (int i = 0; i < P; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (foo2[a - 1].right >= foo2[b - 1].pos && foo2[a - 1].left <= foo2[b - 1].pos) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
		}
	}
}
