
/*
 * @author ljx
 * @date   Oct 30, 2023 2:43:00 PM
 * @email  ljx.1024@outlook.com
 * @Description 
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.text.DateFormatSymbols;
import java.util.HashMap;
import java.util.HashSet;

public class _1403_4 {
	private static HashMap<Integer, HashSet<Integer>> g;
	private static boolean[] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br;
		BufferedWriter bw;
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String ln = br.readLine();
		String[] elems = ln.split(" ");
		int n,m,k,r;
		n = Integer.parseInt(elems[0]);
		m = Integer.parseInt(elems[1]);
		k = Integer.parseInt(elems[2]);
		r = Integer.parseInt(elems[3]);
		
		int[][] pnt = new int[n+m+1][2];
		flag = new boolean[n+m+1];
		for (int i = 0; i < n; i++) {
			int x,y;
			elems=br.readLine().split(" ");
			x = Integer.parseInt(elems[0]);
			y = Integer.parseInt(elems[1]);
			pnt[i][0] = x;
			pnt[i][1] = y;
		}
		
		for (int i = 0; i < m; i++) {
			int x,y;
			elems=br.readLine().split(" ");
			x = Integer.parseInt(elems[0]);
			y = Integer.parseInt(elems[1]);
			pnt[n+i][0]=x;
			pnt[n+i][1] = y;
			
		}
		g = new HashMap<Integer, HashSet<Integer>>();
		// build graph, O(n^2),n=100
		int cnt = n+m;
		for(int i = 0; i<cnt; ++i) {
			for(int j = i+1;j<cnt;++j)
			{
				double dis = calDis(pnt, i, j);
				if(dis<=r) {
					//add edge
					g.putIfAbsent(i, new HashSet<Integer>());
					g.putIfAbsent(j, new HashSet<Integer>());
					g.get(i).add(j);
					g.get(j).add(i);
				}
			}
			
		}
		
		// search between 0 and 1:
		dfs(0);
	} //main

	private static void dfs(int i) {
		// TODO Auto-generated method stub
//		HashSet<Integer> next = 
		
	}

	private static double calDis(int[][] pnt, int i, int j) {
		// TODO Auto-generated method stub
		int x1=pnt[i][0],y1=pnt[i][1];
		int x2=pnt[j][0],y2=pnt[j][1];
		return Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2));
		
	}

}//class
