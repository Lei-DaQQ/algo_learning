import java.util.Scanner;

/*
 * @author ljx
 * @date   2023-3-6 14:53:14
 * @email  ljx.1024@outlook.com
 */

// nmd, dfs都能过
public class _2何以包邮 {
	private static int x, n;
	static int[] price;
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		x = sc.nextInt();
		price = new int[n];
		for (int i = 0; i < n; ++i) {
			price[i] = sc.nextInt();
		}

		////
//		这个问题，好熟悉。。。。
		dfs(0, 0);
		System.out.println(ans);

	} // main

	private static void dfs(int i, int totalP) {
		if (totalP >= x) {
			ans = Math.min(ans, totalP);
			return;
		}
		if (i >= n) {
			return;
		}

		dfs(i + 1, totalP + price[i]);
		dfs(i + 1, totalP);

	}

} // class
