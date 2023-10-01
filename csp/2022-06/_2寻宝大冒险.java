import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

/*
 * @author ljx
 * @date   2023-3-7 10:42:05
 * @email  ljx.1024@outlook.com
 */
public class _2—∞±¶¥Û√∞œ’ {
	static int n, L, S;
	static Pnt[] pnt;
	static Map<Integer, Set<Integer>> pntMap;
	static Map<Integer, ArrayList<Integer>> pntList;
	static int[][] mp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		L = sc.nextInt();
		S = sc.nextInt();

		mp = new int[S + 1][S + 1];
//		Set<Pnt> stPnts = new TreeSet<Pnt>();
		pntMap = new Hashtable();
		pntList = new Hashtable();
		
		pnt = new Pnt[n];
		for (int i = 0; i < n; ++i) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			pnt[i] = new Pnt(x, y);
//			stPnts.add(pnt[i]);
			if (!pntMap.containsKey(x)) {
				pntMap.put(x, new TreeSet<Integer>());
				pntList.put(x, new ArrayList<>());
			}
			pntMap.get(x).add(y);
			pntList.get(x).add(y);
		}

		// input small map
		int smMpTreeNum = 0;
		for (int i = 0; i <= S; ++i) {
			for (int j = 0; j <= S; ++j) {
				mp[i][j] = sc.nextInt();
				if (mp[i][j] == 1) {
					smMpTreeNum++;
				}
			}
		}

		for(Entry<Integer, ArrayList<Integer>> entry: pntList.entrySet()) {
			Collections.sort(entry.getValue());
		}
		
		
		// enumerate n- Trees
		int ans = 0;

		for (int tre = 0; tre < n; ++tre) {
			boolean cant = false;
			int baseR = pnt[tre].x; // row
			int baseC = pnt[tre].y; // col
			// ºÏ≤È∑∂Œßƒ⁄ ˜ƒæ ˝¡ø
			int endR = baseR + S, endC = baseC + S;
			if (endR > L || endC > L) {
				cant = true;
				continue;
			}
			
			int rangeNum = 0;
			for (int r = baseR; r <= endR; ++r) {
				if(pntList.containsKey(r)) {
					ArrayList<Integer> lst = pntList.get(r);
					for(int j = 0; j < lst.size(); ++j)
					{
						if(lst.get(j) >= baseC && lst.get(j) <= endC)
							++rangeNum;
					}
				}
			}
			if(rangeNum != smMpTreeNum) {
				cant = true;
				continue;
			}

			///

			for (int i = 0; i <= S; ++i) {
				for (int j = 0; j <= S; ++j) {
					if (mp[i][j] == 0)
						continue;
					int nR = baseR + S - i, nC = baseC + j;

					if (pntMap.containsKey(nR)) {
						if (pntMap.get(nR).contains(nC)) {
							// ok
						} else {
							cant = true;
							break;

						}
					} else {
						cant = true;
						break;
					}

				}
				if (cant) {
					break;
				}
			}
			if (cant) {

			} else {
				ans++;
			}

		}
		System.out.println(ans);

	}// main
}

class Pnt {
	public int x, y;

	public Pnt(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

/*


5 100 2
3 3
2 2
1 1
1 0
0 0
0 0 1
0 1 0
1 0 0







5 100 0
3 3
2 2
1 1
1 0
0 0
1

*/