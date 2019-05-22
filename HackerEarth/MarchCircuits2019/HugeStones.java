import java.util.Scanner;

class stone {
	int weight, x, y;

	stone(int x, int y, int w) {
		weight = w;
		this.x = x;
		this.y = y;
	}
}

public class HugeStones {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), x = 0, y = 0, totalWeight = 0, I = 0, K;
		stone arr[] = new stone[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new stone(sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		for (int i = 0; i < N; i++) {
			x += arr[i].weight * arr[i].x;
			y += arr[i].weight * arr[i].y;
			totalWeight += arr[i].weight;
		}
		x /= totalWeight;
		y /= totalWeight;
		for (int i = 0; i < N; i++) {
			I += (arr[i].weight) * (Math.pow((arr[i].x - x), 2) + Math.pow((arr[i].y - y), 2));
		}
		K = (int) Math.sqrt(I / totalWeight);
		System.out.println(x + " " + y + " " + K);
		sc.close();
	}
}
