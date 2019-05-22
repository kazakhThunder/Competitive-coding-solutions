import java.util.Scanner;

public class shiftTheLetters {
	static void arrayFormer(int op[], int size) {
		for (int i = 0; i < size; i++) {
			if (op[i] != 0) {
				int count = 0;
				for (int j = i - 1; j >= 0; j--) {
					if (op[j] != 0) {
						break;
					} else {
						count++;
					}
				}
				op[i] += count * op[i];
			}
		}
	}

	static void zeroer(int op[], int size, int index) {
		int ind1 = size, ind2 = -1;
		for (int i = index + 1; i < op.length; i++) {
			if (op[i] > 0) {
				ind1 = i;
				break;
			}
		}
		for (int i = index - 1; i >= 0; i--) {
			if (op[i] > 0) {
				ind2 = i;
				break;
			}
		}

		int u = (index - ind2);
		if (ind1 < size) {
			int t = ((op[ind1]) / (ind1 - index));
			op[ind1] += (t * u);
		}
		int temp = op[index] / u;
		if (ind2 > -1) {
			int tk = ind2 - 2;
			for (int i = ind2 - 1; i >= 0; i--) {
				if (op[i] > 0) {
					tk = i;
					break;
				}
			}
			int temp2 = (ind2 - tk);
			op[ind2] += (temp * temp2);
		}
		op[index] = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String S = sc.next();
		int op[] = new int[S.length() - 1];
		int opCount = 0;
		int KFin = sc.nextInt();
		int KIn = 0;
		for (int i = 0; i < S.length() - 1; i++) {
			if (S.charAt(i) != S.charAt(i + 1)) {
				KIn += 1;
				int t = S.charAt(i + 1) - S.charAt(i);
				int temp = (t < 0) ? (26 + t) : t;
				op[i] = temp;
			}
		}
		arrayFormer(op, S.length() - 1);
		for (int i = 0; i < op.length; i++) {
			System.out.print(op[i] + " ");
		}
		System.out.println();
		while (KFin < KIn) {
			int minInd = 0, min = Integer.MAX_VALUE;
			for (int i = 0; i < op.length; i++) {
				if (op[i] < min && op[i] != 0) {
					minInd = i;
					min = op[i];
				}
			}
			KIn--;
			opCount += op[minInd];
			zeroer(op, op.length, minInd);
		}
		System.out.println(opCount);
	}
}
