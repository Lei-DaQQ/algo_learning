
package lanqiao14;

/*
 * @author ljx
 * @date   Dec 24, 2023 9:04:54 PM
 * @email  ljx.1024@outlook.com
 * @Description 
 */	
import java.io.*;
import java.util.*;

public class _E {
	static int maxn = 200005, n, m, inf = (int) 1e9;
	static long INF = (long) 2e18, ans = 0, mod = (int) 1e9 + 7;
	static Scanner sc = new Scanner(System.in);
	static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	static StreamTokenizer st = new StreamTokenizer(bf);
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		int T = 1;
		while (T-- > 0)
			solve();
		pw.flush();
	}

	static final int I() throws IOException {
		st.nextToken();
		return (int) st.nval;
	}

	static class gas implements Comparable<gas> {
		long c;
		int id;

		public gas(int i, long a) {
			c = a;
			id = i;
		}

		@Override
		public int compareTo(gas o) {
			// TODO Auto-generated method stub
			return this.c - o.c > 0 ? 1 : -1;
		}

	}

	static int rest[] = new int[maxn << 2];
	static int k[] = new int[maxn << 2];
	static int dis[] = new int[maxn];
	static int lim[] = new int[maxn];
	static int cost[] = new int[maxn];
	static int vol = 0;

	static void build(int i, int l, int r) {
		if (l == r) {
			rest[i] = 0; // 到达时油量
			return;
		}
		int mid = (l + r) / 2;
		build(i << 1, l, mid);
		build(i << 1 | 1, mid + 1, r);
		up(i);
	}

	static void up(int i) {
		rest[i] = Math.max(rest[i << 1], rest[i << 1 | 1]);
	}

	static void pd(int i) {
		if (k[i] != 0) {
			k[i << 1] += k[i];
			k[i << 1 | 1] += k[i];
			rest[i << 1] += k[i];
			rest[i << 1 | 1] += k[i];
			k[i] = 0;
		}
	}

	static int query(int i, int l, int r, int ll, int rr) {
		if (ll <= l && r <= rr)
			return rest[i];
		pd(i);
		int res = 0;
		int mid = (l + r) / 2;
		if (mid >= ll)
			res = Math.max(res, query(i << 1, l, mid, ll, rr));
		if (mid < rr)
			res = Math.max(res, query(i << 1 | 1, mid + 1, r, ll, rr));
		up(i);
		return res;
	}

	static void add(int i, int l, int r, int ll, int rr, int v) {
		if (ll <= l && r <= rr) {
			rest[i] += v;
			k[i] += v;
			return;
		}
		pd(i);
		int mid = (l + r) / 2;
		if (mid >= ll)
			add(i << 1, l, mid, ll, rr, v);
		if (mid < rr)
			add(i << 1 | 1, mid + 1, r, ll, rr, v);
		up(i);
	}

	static void solve() throws IOException {
		n = I();
		m = I();
		vol = m;
		PriorityQueue<gas> q = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			dis[i] = I();
			cost[i] = I();
			lim[i] = I();
		}
		build(1, 1, n);
		for (int i = 1; i <= n; i++) {
			vol -= dis[i];
			while (vol < 0) {
				if (q.isEmpty()) {
					pw.println(-1);
					return;
				}
				gas a = q.poll();
				int cnt = Math.min(m - query(1, 1, n, a.id, i - 1), lim[a.id]);
				if (cnt <= 0)
					continue;
				if (cnt <= -vol) {
					ans += a.c * cnt;
					vol += cnt;
					lim[a.id] = 0;
					add(1, 1, n, a.id, i - 1, cnt);
				} else {
					ans += a.c * (-vol);
					lim[a.id] = cnt + vol;
					add(1, 1, n, a.id, i - 1, -vol);
					q.add(new gas(a.id, a.c));
					vol = 0;
				}
			}
			if (vol > 0)
				add(1, 1, n, i, i, vol);
			lim[i] = Math.min(lim[i], m - vol);
			q.add(new gas(i, cost[i]));
		}
		pw.println(ans);
	}
}
