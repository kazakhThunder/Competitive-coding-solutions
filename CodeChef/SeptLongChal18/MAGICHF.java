import java.util.Scanner;

class box {
	boolean has;
}

public class MagVerChef {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int S = sc.nextInt();
			box[] arr = new box[N + 1];
			for (int j = 1; j < arr.length; j++) {
				arr[j] = new box();
			}
			arr[X].has = true;
			for (int j = 0; j < S; j++) {
				int a=sc.nextInt();
				int b=sc.nextInt();
				boolean temp=arr[a].has;
				arr[a].has=arr[b].has;
				arr[b].has=temp;
			}
			for (int j = 1; j < arr.length; j++) {
				if(arr[j].has==true)
				{
					System.out.println(j);
					break;
				}
			}
		}
		sc.close();
	}
}
