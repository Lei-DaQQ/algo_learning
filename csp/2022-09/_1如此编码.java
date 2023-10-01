import java.util.Arrays;
import java.util.Scanner;

/*
 * @author ljx
 * @date   2023-3-6 14:27:39
 * @email  ljx.1024@outlook.com
 */
public class _1Èç´Ë±àÂë {
	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();

		int[] arr = new int[n + 1];
		long[] prefix = new long[n + 1];
		Arrays.fill(prefix, 1);
		for (int i = 1; i <= n; ++i) {
			arr[i] = sc.nextInt();
			prefix[i] *= arr[i] * prefix[i - 1];
		}
		//
		long bi = 0;
		for (int i = 1; i <= n; ++i) {
//			System.out.println(prefix[i-1]);
			bi = (m % prefix[i]) / prefix[i - 1];
			m -= bi;
			System.out.print(bi + " ");
		}

	}
}
