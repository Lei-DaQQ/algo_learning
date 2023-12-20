import java.util.Scanner;

public class _94递归实现排列型枚举 {
	private static int n;
	private static int[] st;
	private static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		st = new int[n+1];
		used = new boolean[n+1];
				
		// 全排列

		dfs(1);//
	}

	private static void dfs(int u) {
		if (u == n + 1) {
			for (int i = 1; i <= n; ++i) {
				System.out.print(st[i] + " ");
			}
			System.out.println();
			return;
		}
		// 果然不能格式化是因为和微软的繁简切换冲突了，但是我没有安装其他输入法

		// start to choose which number
		for (int i = 1; i <= n; ++i) {
			if (used[i])
				continue; // here have a [;]
			used[i] = true;
			st[u] = i;
			dfs(u + 1);
			// 需不需要恢复呢，需要
			used[i] = false;
		}

	}

}
//不应该错啊，妈的，忘了continue，装失误了