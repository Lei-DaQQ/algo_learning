import java.util.Scanner;

public class _95费解的开关 {
	private static int n;
	private static String[] st;
	private static int[] back_up;

	static int[] dr = { -1, 0, 0, +1 }, dc = { 0, -1, 1, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		st = new String[5];
		back_up = new int[5];
		
		for (int i = 0; i < n; ++i) {
			
			sc.nextLine();
			for (int j = 0; j < 5; ++j) {
				st[j] = sc.nextLine();
			}
			
			int min_ans = 999;
			boolean could = true;
			
			// begin to enumerate the choices: 0~31
			for (int action = 0; action <= 31; ++action) {
				for (int t = 0; t < 5; ++t) {
					back_up[t] =  Integer.parseInt(st[t], 2);
				}
				// bit 1, click
				// bit 0, nothing to do

				int res = 0;
				for (int bit = 4; bit >= 0; --bit) {
					if ((action & (1 << bit)) != 0) {
						++res;
						turn(0, bit);
					}
				}

				// 根据第1行的状态决定第二行的按否
//				int next_row_action = 0;
				for (int r = 0; r < 4; ++r) {
//					next_row_action = 0;
					for (int bit = 4; bit >= 0; --bit) {
						if ((back_up[r] & (1 << bit)) == 0) {
							// 按
							++res;
							turn(r + 1, bit);
//							next_row_action |= (1 << bit);
						}

					} // this row finish

				}

				// 判断是否全亮
				could = true;
				if (res > 6) {
					could = false;
					continue;
				}
				for (int r = 0; r < 5; ++r) {
					if (back_up[r] != 31) {
						could = false;
						break;
					}
				}
				if (could) {
					min_ans = Math.min(min_ans, res);
				}

			} // 0 ~ 31
			if (min_ans < 999)
				System.out.println(min_ans);
			else
				System.out.println(-1);
		} // n test cases

	} // main

	// press the r-th row, the c-th col
	private static void turn(int r, int c) {
		back_up[r] ^= (1 << c);
		for (int dir = 0; dir < 4; ++dir) {
			int nr = r + dr[dir], nc = c + dc[dir];
			// 判断越界
			if (nr < 0 | nr > 4 | nc < 0 | nc > 4) {
				continue;
			}
			back_up[nr] ^= (1 << nc);

		}

	}
}
/*
1
11111
11111
11111
11111
11111

*/