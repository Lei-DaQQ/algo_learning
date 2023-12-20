import java.util.Scanner;

public class _D {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a, b;
		Scanner sc = new Scanner(System.in);
		a = sc.nextLong();
		b = sc.nextLong();

		long gcd = Math.abs(a - b);
		long res = a / gcd * gcd + (a % gcd != 0 ? gcd : 0);
		res = res - a;
		System.out.println(res);
	}

}
