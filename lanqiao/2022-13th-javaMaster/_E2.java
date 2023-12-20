import java.util.ArrayList;
import java.util.Scanner;

public class _E2 {
	static double[] d0 = { 1, 1, 0, -1, -1, 0 };
	static double[] d2 = { 0, 1, 1, 0, -1, -1 };
//	static double[] d0 = { 1, 0.5, 0, -1, -0.5, 0 };
//	static double[] d2 = { 0, 0.5, 1, 0, -0.5, -1 };

	public static void main(String[] args) {
//		System.out.println(Math.cos(Math.PI)); // this is hudu,
		int d1, p1, q1;
		int d2, p2, q2;
		Scanner sc = new Scanner(System.in);
		d1 = sc.nextInt();
		p1 = sc.nextInt();
		q1 = sc.nextInt();
		d2 = sc.nextInt();
		p2 = sc.nextInt();
		q2 = sc.nextInt();

		Point2 pnt1 = new Point2(), pnt2 = new Point2();
		getXY(d1, p1, q1, pnt1);
		getXY(d2, p2, q2, pnt2);

		double x = pnt1.p0 - pnt2.p0;
		double y = pnt1.p2 - pnt2.p2;

		double res = 0;
		if (x * y < 0)
			res = Math.abs(x) + Math.abs(y);
		else if (x > 0 && y > 0) {
			if (x > y) {
				res = x;
			} else if (x < y) {
				res = y;
			} else
				res = x;
		} else if (x < 0 && y < 0) {
			if (x < y) {
				res = -x;
			} else if (y < x) {
				res = -y;
			} else
				res = -x;
		} else {
			res = Math.max(x, y);
		}
		long ans = (long) res;
		System.out.println(ans);

	}

	public static void getXY(int d, int p, int q, Point2 pnt) {
		double p0 = p * d0[d] + q * d0[(d + 2) % 6];
		double p2 = p * d2[d] + q * d2[(d + 2) % 6];

		pnt.p0 = p0;
		pnt.p2 = p2;
	}
//	0 5 3 2 3 2
//	5 920 176 4 919 596
}

class Point2 {
	public double p0, p2;

}
