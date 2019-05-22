
import java.util.Arrays;
import java.util.Scanner;

public class superheroGangPower {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double n = sc.nextDouble(), k = sc.nextDouble(), m = sc.nextDouble();
		double arr[] = new double[(int) (n + 1)];
		double preSum[] = new double[(int) (n + 1)];
		for (int i = 1; i < n + 1; i++) {
			arr[i] = sc.nextDouble();
		}
		Arrays.sort(arr);
		preSum[1] = arr[1];
		for (int i = 2; i < preSum.length; i++) {
			preSum[i] = arr[i] + preSum[i - 1];
		}
		if (n != 1) {
			double max = (preSum[(int) n] - preSum[1] + Double.min(m - 1, k * (n - 1))) / (n - 1);
			for (int i = 2; i < Double.min(m, n - 1); i++) {
				double fi = ((preSum[(int) n] - preSum[i]) + Double.min(m - i, k * (n - i))) / (n - i);
				if (fi > max) {
					max = fi;
				}
			}
			System.out.println(max);
		} else {
			System.out.println(arr[1]+k);
		}
	}
}
