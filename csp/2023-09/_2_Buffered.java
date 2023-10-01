
/*
 * @author ljx
 * @date   Oct 1, 2023 5:50:05 PM
 * @email  ljx.1024@outlook.com
 * @Description ×ø±ê±ä»»2   !!!750ms
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class _2_Buffered {
	private static int n;
	private static int m;
	static double[] stretch;
	static double[] rotate;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] ln = br.readLine().split(" ");
		n = Integer.parseInt(ln[0]);
		m = Integer.parseInt(ln[1]);
		stretch = new double[n + 1];
		rotate = new double[n + 1];
		stretch[0] = 1.0;
		rotate[0] = 0.0;

		int op;
		double t;
		for (int i = 1; i <= n; ++i) {
			ln = br.readLine().split(" ");
			op = Integer.parseInt(ln[0]);
			t=Double.parseDouble(ln[1]);
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
			ln = br.readLine().split(" ");
			l = Integer.parseInt(ln[0]);
			r = Integer.parseInt(ln[1]);
			x = Integer.parseInt(ln[2]);
			y = Integer.parseInt(ln[3]);
			process(l,r,x,y);
		}
//		br.close();
		bw.flush();
	}

	private static void process(int l, int r, int x, int y) throws IOException {
		double ratio = stretch[r] / stretch[l-1];
		double degree = rotate[r] - rotate[l-1];
		double np[] = new double[2];
		np = doRotate(x, y, degree);
		np[0] *= ratio;
		np[1] *= ratio;
		bw.write(np[0] + " " + np[1] + "\n");
	}

	private static double[] doRotate(int x, int y, double degree) {
		double cos = Math.cos(degree), sin = Math.sin(degree);
		double nx = x * cos - y * sin;
		double ny = x * sin + y * cos;
		return new double[]{nx, ny};
	}
}
