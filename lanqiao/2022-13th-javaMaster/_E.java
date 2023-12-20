import java.util.ArrayList;
import java.util.Scanner;

public class _E {
	static double[] pi = { 1, 2.0 / 3, 1.0 / 3, 0, -1.0 / 3, -2.0 / 3 };
	static double[] cos = { -1, -0.5, 0.5, 1, 0.5, -0.5 };
	static double[] sin = { 0, -0.5, 0.5, 1, 0.5, -0.5 };

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

		Point pnt1 = new Point(), pnt2 = new Point();
		getXY(d1, p1, q1, pnt1);
		getXY(d2, p2, q2, pnt2);
		double x1 = pnt1.x, y1 = pnt1.y;
		double x2 = pnt2.x, y2 = pnt2.y;
		
		double x_1 = (y1 - y2 + Math.sqrt(3) * x2) / Math.sqrt(3);
		double x_2 = (y1 - y2 - Math.sqrt(3) * x2) / (-Math.sqrt(3));

		System.out.println("x_1 : " + x_1 + ", x_2:" + x_2);

		double delta_x = Math.min(Math.abs(x_1 - x1), Math.abs(x_2 - x1));
		double delta_vertical = Math.abs(y2 - y1) / Math.sin(Math.PI * 1.0 / 3);
		// shoule be 'xie bian er', Not vertical

		long dx = (long) Math.floor(delta_x);
		long dy = (long) Math.floor(delta_vertical);
		System.out.println("delta x :" + dx + ", vertical: " + dy);

		long res = dx + dy;
		System.out.println(res);

		System.out.println("point1: " + pnt1.x + ",  " + pnt1.y);
		System.out.println("point2: " + pnt2.x + ",  " + pnt2.y);

	}

	public static void getXY(int d, int p, int q, Point pnt) {
//		double x1 = p * cos[d]Math.cos(Math.PI * pi[d]) + q * Math.cos(Math.PI * pi[(d + 2) % 6]);
		double x1 = p * cos[d] + q * cos[(d + 2) % 6];
		double y1 = p * Math.sin(Math.PI * pi[d]) + q * Math.sin(Math.PI * pi[(d + 2) % 6]);

		pnt.x = x1;
		pnt.y = y1;
	}
//	0 5 3 2 3 2
}

class Point {
	public double x, y;

}
