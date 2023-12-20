import java.util.Scanner;

public class _717¼òµ¥ì³²¨ÄÇÆõ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long a = 0, b = 1, c;
//		if (n == 1)
//			System.out.println(0);
//		else if (n == 2)
//			System.out.println("0 1");
//		else {
//			System.out.print("0 1 ");
//			for (int i = 3; i <= n; ++i) {
//
//				c = a + b;
//				System.out.print(c + " ");
//				a = b;
//				b = c;
//			}
//		}
		for (int i = 1; i <= n; ++i) {
			System.out.print(a + " ");
			c = a + b;
			a = b;
			b = c;
		}

	}
}
