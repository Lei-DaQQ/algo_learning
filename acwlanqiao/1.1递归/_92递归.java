import java.util.Scanner;

public class _92�ݹ� {
	static int[] st;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		st = new int[n];
		
		//�����ǣ�ѡ��ѡ��ͬʱ�������ݣ�Ȼ����һ��
		dfs(0, st);
	}
	//��ݼ���̫��Ϥ�ˣ��﷨Ҳ���˺ö�
	public static void dfs(int u, int[] st) {
		// 0, 1, ..., n-1
		if(u == n) {
			for(int i = 0; i < n; ++i)
			{
				//�������е������ˣ�����������
				if(st[i] == 1)
					System.out.print((i+1) + " ");
			
			}
			System.out.println();
			return;
		}
		
		//choose
		st[u] = 1;
		//���ô�st�ˣ���Ϊ��static
		dfs(u+1, st);
		
		// don't choose
		st[u] = 0;
		dfs(u+1, st);
		
	}
	
}
//666
