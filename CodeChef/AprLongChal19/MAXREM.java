import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class MaximumRemaining {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		HashSet<Integer> hs = new HashSet<Integer>(n);
		for (int i = 0; i < n; i++) {
			hs.add(sc.nextInt());
		}
		sc.close();
		ArrayList<Integer> arL = new ArrayList<Integer>(hs.size());
		arL.addAll(hs);
		hs.clear();
		Collections.sort(arL);
		int start = arL.size() - 1, max = 0;
		while (start != 0 && max == 0) {
			max = (arL.get(start - 1) % arL.get(start));
			--start;
		}
		System.out.println(max);

	}
}
