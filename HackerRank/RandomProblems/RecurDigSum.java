
import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class RecurDigSum {

	static BigInteger superDig(String n, int k) {
		BigInteger p = new BigInteger(n).multiply(new BigInteger(k + ""));
		if (p.remainder(new BigInteger("9")).equals(BigInteger.ZERO)) {
			p = new BigInteger("9");
		}
		else
		{
			p=p.remainder(new BigInteger("9"));
		}
		return p;
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int k = sc.nextInt();
		System.out.println(superDig(n, k));

	}
}