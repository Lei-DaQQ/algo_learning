import java.util.ArrayList;
import java.util.Scanner;

/*
 * @author ljx
 * @date   2023-3-6 10:33:21
 * @email  ljx.1024@outlook.com
 */
public class _2训练计划 {

	static int[] fa;
//	static int[] cd;
	static ArrayList<ArrayList<Integer>> cd;
// 被多次依赖的处理
	
	public static void main(String[] args) {
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		fa = new int[m + 1];
		cd = new ArrayList<>(m+1);
		for(int i = 0; i <= m; ++i)
		{
			cd.add(new ArrayList<>());
		}
		
		
		
		int[] time = new int[m + 1];
		int[] st_ear = new int[m + 1];
		int[] st_lat = new int[m + 1];
		st_ear[0] = 1;

		fa[0] = 0;
		for (int i = 1; i <= m; ++i) {
			int f = sc.nextInt();
			fa[i] = f;
			cd.get(f).add(i);
		}
		for (int i = 1; i <= m; ++i) {
			time[i] = sc.nextInt();
		}

		boolean cant_finish = false;
		for (int i = 1; i <= m; ++i) {
//			int f = find_fa(i);
			int f = fa[i];
			st_ear[i] = st_ear[f] + time[f];
			if (st_ear[i] + time[i] - 1 > n)
				cant_finish = true;
		}

		st_lat[0] = n + 1;
		for (int i = m; i >= 1; --i) {
			
			// 找到子节点的最晚开始，min
			ArrayList<Integer> arr = cd.get(i);
			int min_of_stLat = n+1;
			for(int j = 0; j < arr.size(); ++j) {
				min_of_stLat = Math.min(min_of_stLat, st_lat[arr.get(j)]);
			}
			
			
			st_lat[i] = min_of_stLat - time[i];
		}
		// output
		for (int i = 1; i <= m; ++i) {
			System.out.print(st_ear[i] + " ");
		}
		if (cant_finish) {
			return;
		} else {
			System.out.println();
			for (int i = 1; i <= m; ++i) {
				System.out.print(st_lat[i] + " ");
			}

		}
	}

	private static int find_fa(int i) {
		// TODO Auto-generated method stub
		int f = i;
		while (fa[f] != 0) {
			f = fa[f];
		}
		return 0;
	}
}
