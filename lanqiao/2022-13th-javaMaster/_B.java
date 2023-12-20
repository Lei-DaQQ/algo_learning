
public class _B {
	public static long[] remain = { 0, 0, 1, 2, 1, 4, 5, 4, 1, 2, 9, 0, 5, 10, 11, 14, 9, 0, 11, 18, 9, 11, 11, 15, 17,
			9, 23, 20, 25, 16, 29, 27, 25, 11, 17, 4, 29, 22, 37, 23, 9, 1, 11, 11, 33, 29, 15, 5, 41, 46 };

	public static void main(String[] args) {

		// 48,49 : 2153
		// gcd(48,49) = 2352

		remain[48] = 2153;
		long t_lcm = lcm(48, 49);
		for (int a = 47; a >= 2; --a) {
			remain[a] = dfs1(a, t_lcm, remain[a + 1]);
			t_lcm = lcm(a, t_lcm);
			System.out.println("step   " + remain[a]);
		}
		System.out.println(remain[2]);

	}// main

	public static long dfs1(int a, long b, long new_remain) {
		long n = new_remain;

		for (;; n += b) {
			System.out.println(n);
			if (n % a == remain[a] && n % b == new_remain)
				break;
		}
		return n;

	} // dfs

	public static long lcm(long a, long b) {
		return a * b / gcd(a, b);

	}

	public static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
}// Class Main
