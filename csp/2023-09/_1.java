
/*
 * @author ljx
 * @date   Oct 1, 2023 5:34:03 PM
 * @email  ljx.1024@outlook.com
 * @Description 坐标变换1
 * <a href='http://118.190.20.162/view.page?gpid=T175'>计算机软件能力认证考试系统</a>
 */
import java.util.ArrayList;
import java.util.Scanner;

public class _1 {

	private static int n;
	private static int m;
	static int[] dx, dy;
	static int[] x, y;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		dx = new int[n];
		dy = new int[n];
		x = new int[m];
		y = new int[m];
		for (int i = 0; i < n; ++i) {
			dx[i] = sc.nextInt();
			dy[i] = sc.nextInt();
		}

		for (int i = 0; i < m; ++i) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		for (int i = 0; i < m; ++i) {
			process(x[i], y[i]);
		}
	}

	private static void process(int x, int y) {
		// TODO Auto-generated method stub
		for (int i = 0; i < n; ++i) {
			x += dx[i];
			y += dy[i];
		}
		System.out.println(x + " " + y);
	}

}
