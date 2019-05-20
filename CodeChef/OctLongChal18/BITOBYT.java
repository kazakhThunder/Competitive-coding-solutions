import java.math.BigInteger;
import java.util.Scanner;

public class BitToByte {
	static BigInteger pow(int a)
	{
		String st=a+"";
		BigInteger bi=new BigInteger("2");
		BigInteger bi1=new BigInteger("1");
		for (int i = 0; i < a; i++) {
			bi1=bi1.multiply(bi);
		}
		return bi1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int N=sc.nextInt();
			int cycles,p;
			BigInteger bits,nibbles,bytes;
			nibbles=new BigInteger("0");
			bytes=new BigInteger("0");
			cycles=p=0;
			N=N-1;
			cycles=N/26;
			bits=pow(cycles);
			p=N-(cycles*26);
			if(p>=2&&p<=9)
			{
				nibbles=bits;
				bits=bytes;
			}
			else if(p>=10&&p<=25)
			{
				bytes=bits;
				bits=nibbles;
			}
			System.out.println(bits+" "+nibbles+" "+bytes);
		}
	}
}