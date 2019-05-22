public class BetTwoSets {
	static int exp(int a,int x)
	{
		if(x==0)
		{
			return 1;
		}
		else
		{
			return a*exp(a,x-1);
		}
	}
	public static void main(String[] args) {
		System.out.println(exp(3,3));
		
	}
}