package hackerEarthNovCircuits18;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class ratio {
	int[] rat(int a,int b)
	{
		int small=(a>b)?b:a;
		for (int i = 0; i < array.length; i++) {
			
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner r = new Scanner(System.in);
		int T = r.nextInt();
		for (int i = 0; i < T; i++) {
			ArrayList<Character> arr = new ArrayList<Character>();
			int N = r.nextInt();
			int aCount = 0, bCount = 0;
			for (int j = 0; j < N; j++) {
				int a = r.nextInt();
				char b = r.next().charAt(0);
				boolean dec = (b == 'B') ? true : false;
				if (dec) {
					bCount += a;
				} else {
					aCount += a;
				}
				for (int k = 0; k < a; k++) {
					arr.add(b);
				}
				int arr1[]= {1,3};
				
			}

		}
	}
}
