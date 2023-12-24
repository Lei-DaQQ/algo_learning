
/*
 * @author ljx
 * @date   Dec 24, 2023 3:23:38 PM
 * @email  ljx.1024@outlook.com
 * @Description 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _F小蓝的旅行计划 {
	public static BufferedReader br;
	public static BufferedWriter bw;
	public static int n, m;
	public static int[] dis, cost, lim;

	public static void main(String[] args) throws IOException {

		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String line = br.readLine();
		String[] elems = line.split(" ");
		n = Integer.parseInt(elems[0]);
		m = Integer.parseInt(elems[1]);

		dis = new int[n + 1];
		cost = new int[n + 1];
		lim = new int[n + 1];

		for (int i = 1; i <= n; ++i) {
			elems = br.readLine().split(" ");
			dis[i] = Integer.parseInt(elems[0]);
			cost[i] = Integer.parseInt(elems[1]);
			lim[i] = Integer.parseInt(elems[2]);
		}
		

		bw.flush();
	}
}
