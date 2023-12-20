
/*
 * @author ljx
 * @date   Dec 20, 2023 10:48:47 AM
 * @email  ljx.1024@outlook.com
 * @Description 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;

/*
|_|_|_|_|
|_|_|_|_|
|_|_|_|_|

3行 4列，将中间的四方格都+1，
我相信如果学习过研究生课程组合数学，鸽巢原理这一章节，会容易理解一些，
但是我也相信这一章节不学习，大家也都有所了解

*/

/*

3 3
1 1 2 2
2 2 3 3
1 1 3 3

*/
public class _C棋盘 {
	public static BufferedReader br;
	public static BufferedWriter bw;

	public static int[][] data;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String ln = br.readLine();
		String[] elems = ln.split(" ");
		int n = Integer.parseInt(elems[0]);
		int m = Integer.parseInt(elems[1]);

		data = new int[n + 1][n + 1];

		for (int i = 0; i < m; i++) {
			int x1, y1, x2, y2;
			elems = br.readLine().split(" ");
			x1 = Integer.parseInt(elems[0]);
			y1 = Integer.parseInt(elems[1]);
			x2 = Integer.parseInt(elems[2]);
			y2 = Integer.parseInt(elems[3]);

			data[x1][y1]++;
			if (x2 + 1 <= n)
				data[x2 + 1][y1]--;
			if (y2 + 1 <= n)
				data[x1][y2 + 1]--;
			if (x2 + 1 <= n && y2 + 1 <= n)
				data[x2 + 1][y2 + 1]++;
		}

		int[][] prefix = new int[n + 1][n + 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				prefix[i][j] = prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1] + data[i][j];
				if ((prefix[i][j] & 1) == 1)
					bw.write("1");
				else
					bw.write("0");
			}
			bw.write("\n");
		}

		bw.flush();
	} // main

}
