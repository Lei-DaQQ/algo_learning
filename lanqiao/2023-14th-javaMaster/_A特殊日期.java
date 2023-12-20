
/*
 * @author ljx
 * @date   Dec 19, 2023 4:10:58 PM
 * @email  ljx.1024@outlook.com
 * @Description 
 * 35813063
 */

import java.util.Calendar;

public class _A特殊日期 {
	private static int ans;

	public static void main(String[] args) {
//		System.out.println("Hello");
		Calendar calendar = Calendar.getInstance();
		int yy = 2000;
		int mm = Calendar.JANUARY;
		int dd = 1;

		
		calendar.set(yy, mm, dd);
		while (!(yy >= 2000000 && mm >= 0 && dd >= 2)) {
//			System.out.println(yy);
			if (yy % (mm + 1) != 0) {
				calendar.add(Calendar.MONTH, 1);
				// date 不需要改变，因为如果月份是不整除，一定是那个月的1号
				mm = calendar.get(Calendar.MONTH);
				yy = calendar.get(Calendar.YEAR);
				continue;
			}

			if (yy % dd == 0) {
				ans++;
//				if (yy >= 1999998) {
//					System.out.println(yy + " " + (mm + 1) + " " + dd);
//				}
			}
			calendar.add(Calendar.DATE, 1);
			yy = calendar.get(Calendar.YEAR);
			mm = calendar.get(Calendar.MONTH);
			dd = calendar.get(Calendar.DATE);
		}
		System.out.println(ans);

	}

}
