import java.util.Scanner;

public class ImitationGames {
public static void main(String[] args) {
	int N,M;
	Scanner sc=new Scanner(System.in);
	N=sc.nextInt();
	M=sc.nextInt();
	String eater=sc.nextLine();
	String workPiece=sc.nextLine();
	sc.close();
	int size=M/N;
	String arr[]=new String[M/N];
	int index=workPiece.length()/size;
	//String MSize;
	int t=0;
	for (int i = 0; i <workPiece.length() ; i=index+i) {
		arr[t]=workPiece.substring(i, i+index);
		t++;
	}
	String ans=arr[0];
	for (int i = 1; i < M/N; i++) {
		if((i+1)%2==0)
		{
			ans=arr[i]+ans;
		}
		else
		{
			ans=ans+arr[i];
		}
	}
	System.out.println(ans);
}
}
