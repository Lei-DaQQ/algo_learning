import java.util.Scanner;

public class _94�ݹ�ʵ��������ö�� {
	private static int n;
	private static int[] st;
	private static boolean[] used;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		st = new int[n+1];
		used = new boolean[n+1];
				
		// ȫ����

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
		// ��Ȼ���ܸ�ʽ������Ϊ��΢��ķ����л���ͻ�ˣ�������û�а�װ�������뷨

		// start to choose which number
		for (int i = 1; i <= n; ++i) {
			if (used[i])
				continue; // here have a [;]
			used[i] = true;
			st[u] = i;
			dfs(u + 1);
			// �費��Ҫ�ָ��أ���Ҫ
			used[i] = false;
		}

	}

}
//��Ӧ�ô�����ģ�����continue��װʧ����