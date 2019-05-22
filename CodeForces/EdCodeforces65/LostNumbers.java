import java.util.Scanner;

public class LostNumbers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr[] = { 4, 8, 15, 16, 23, 42 };
		int finArr[] = new int[6];
		System.out.println("? 1 1");
		finArr[0] = (int) Math.sqrt(sc.nextDouble());
		System.out.flush();
		System.out.println("? 2 2");
		finArr[1] = (int) Math.sqrt(sc.nextDouble());
		System.out.flush();
		System.out.println("? 3 4");
		int temp = sc.nextInt();
		System.out.flush();
		int i = 0, j = 0;
		int flag = 0;
		for (i = 0; i < 6; i++) {
			for (j = i + 1; j < 6; j++) {
				if ((arr[i] * arr[j]) == temp) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				break;
			}
		}
		System.out.println("? 4 5");
		int anTemp = sc.nextInt();
		System.out.flush();
		int k = 0, l = 0;
		flag = 0;
		for (k = 0; k < 6; k++) {
			for (l = k + 1; l < 6; l++) {
				if (arr[k] * arr[l] == anTemp) {
					flag = 1;
					break;
				}
			}
			if (flag == 1) {
				break;
			}
		}
		if (i == k) {
			finArr[3] = arr[i];
			finArr[2] = arr[j];
			finArr[4] = arr[l];
		} else if (i == l) {
			finArr[3] = arr[i];
			finArr[2] = arr[j];
			finArr[4] = arr[k];
		} else if (j == k) {
			finArr[3] = arr[j];
			finArr[2] = arr[i];
			finArr[4] = arr[l];
		} else if (j == l) {
			finArr[3] = arr[j];
			finArr[2] = arr[i];
			finArr[4] = arr[k];
		}
		for (int l2 = 0; l2 < finArr.length; l2++) {
			temp = arr[l2];
			flag = 0;
			for (int m = 0; m < finArr.length; m++) {
				if (finArr[m] == temp) {
					flag = 1;
					break;
				}
			}

			if (flag == 0) {
				finArr[5] = temp;
				break;
			}
		}
		System.out.print("! ");
		for (int l2 = 0; l2 < finArr.length; l2++) {
			System.out.print(finArr[l2] + " ");
		}
	}
}
