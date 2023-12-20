
/*
 * @author ljx
 * @date   Dec 19, 2023 4:50:54 PM
 * @email  ljx.1024@outlook.com
 * @Description 
 * 34
 */
public class _BÓë»òÒì»ò {
	public static int[] ops = { 0, 1, 2 };
	public static int[][] arr;
	public static int[][] eachop;
	private static int ans;

	public static void main(String[] args) {
		int n = 5;
		arr = new int[n][n];
		eachop = new int[n][n];

		arr[0] = new int[] { 1, 0, 1, 0, 1 };

		dfs(1, 1);
		System.out.println(ans);
	}

	private static void dfs(int i, int j) {
		// TODO Auto-generated method stub
		if (i > 4) {
			cal();
			return;
		}
		for (int op : ops) {
			eachop[i][j] = op;

//			newi, newj £¡£¡£¡£¡
			int newi = i, newj = j;
			if (newi + newj >= 5) {

				newi++;
				newj = 1;
			} else
				newj++;
			dfs(newi, newj);
		}

	}

	private static void cal() {
		// TODO Auto-generated method stub
		for (int i = 1; i <= 4; ++i) {
			for (int j = 0; j <= 4 - i; ++j) {
				if (eachop[i][j + 1] == 0) {
					arr[i][j] = arr[i - 1][j] & arr[i - 1][j + 1];
				} else if (eachop[i][j + 1] == 1) {
					arr[i][j] = arr[i - 1][j] | arr[i - 1][j + 1];

				} else {

					arr[i][j] = arr[i - 1][j] ^ arr[i - 1][j + 1];
				}
			}
		}

		if (arr[4][0] == 1)
			ans++;
	}

}
