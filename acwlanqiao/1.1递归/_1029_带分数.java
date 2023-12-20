import java.util.Scanner;

public class _1029_������ {
	private static int n;
	private static int[] st;
	private static boolean[] used;
	private static int ans;

	public static void main(String[] args) {
		// 1~9���У�Ȼ��ѡ������λ���з�
		// 9! * C(8,2) 8 ��λ��ѡ2

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		st = new int[10];
		used = new boolean[10];

		dfs(1);
		System.out.println(ans);

	}

	private static void dfs(int u) {
		// TODO Auto-generated method stub
		if (u == 10) {
			// ��ʼ�з�λ��
			for (int i = 1; i < 8; ++i) {
				for (int j = i + 1; j <= 8; ++j) {
					// �õ�3����
					int num1 = getNum(1, i);
					int num2 = getNum(i + 1, j);
					int num3 = getNum(j + 1, 9);
					// ��
					if(num2 % num3 == 0)
					{
						if (num1 + num2 / num3 == n)
							ans++;
						
					}
				}
			}
			return; // bujia ye xing
		}

		for (int i = 1; i <= 9; ++i) {
			if (used[i])
				continue;
			used[i] = true;
			st[u] = i;
			dfs(u + 1);
			used[i] = false;
		}

	}// dfs

	private static int getNum(int start, int end) {
		int num = 0;
		while (start <= end) {
			num *= 10;
			num += st[start];
			start++;
		}
		return num;
	}

}
