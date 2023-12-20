import java.util.Scanner;

public class _92递归 {
	static int[] st;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		st = new int[n];
		
		//方案是，选或不选，同时存下数据，然后下一个
		dfs(0, st);
	}
	//快捷键不太熟悉了，语法也忘了好多
	public static void dfs(int u, int[] st) {
		// 0, 1, ..., n-1
		if(u == n) {
			for(int i = 0; i < n; ++i)
			{
				//不带换行的忘记了，好像就是这个
				if(st[i] == 1)
					System.out.print((i+1) + " ");
			
			}
			System.out.println();
			return;
		}
		
		//choose
		st[u] = 1;
		//不用传st了，因为是static
		dfs(u+1, st);
		
		// don't choose
		st[u] = 0;
		dfs(u+1, st);
		
	}
	
}
//666
