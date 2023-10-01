
/*
 * @author ljx
 * @date   Oct 1, 2023 5:50:05 PM
 * @email  ljx.1024@outlook.com
 * @Description ×ø±ê±ä»»2    !!!1.828s
 */

import java.util.Scanner;

public class _2 {
	private static int n;
	private static int m;
	static double[] stretch;
	static double[] rotate;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		stretch = new double[n + 1];
		rotate = new double[n + 1];
		stretch[0] = 1.0;
		rotate[0] = 0.0;

		int op;
		double t;
		for (int i = 1; i <= n; ++i) {
			op = sc.nextInt();
			t = sc.nextDouble();
			if (op == 1) {
				stretch[i] = t * stretch[i - 1];
				rotate[i] = rotate[i - 1];
			} else {
				rotate[i] = t + rotate[i - 1];
				stretch[i] = stretch[i - 1];
			}
		}

		int l, r, x, y;
		for (int i = 0; i < m; ++i) {
			l = sc.nextInt();
			r = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			process(l,r,x,y);
		}
		
	}

	private static void process(int l, int r, int x, int y) {
		double ratio = stretch[r] / stretch[l-1];
		double degree = rotate[r] - rotate[l-1];
		double np[] = new double[2];
		np = doRotate(x, y, degree);
		np[0] *= ratio;
		np[1] *= ratio;
		System.out.println(np[0] + " " + np[1]);
	}

	private static double[] doRotate(int x, int y, double degree) {
		double cos = Math.cos(degree), sin = Math.sin(degree);
		double nx = x * cos - y * sin;
		double ny = x * sin + y * cos;
		return new double[]{nx, ny};
	}
}
