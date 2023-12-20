
package lanqiao14;
/*
 * @author ljx
 * @date   Dec 19, 2023 4:49:42 PM
 * @email  ljx.1024@outlook.com
 * @Description 
 */

/*
 * @author ljx
 * @date   Dec 19, 2023 4:00:09 PM
 * @email  ljx.1024@outlook.com
 * @Description 
 * <a href='https://blog.csdn.net/weixin_44025775/article/details/134856127'>第十四届蓝桥杯大赛软件赛省赛.Java研究生组-试题A:特殊日期-CSDN博客</a>
 */


public class _A {
	public static void main(String[] args) {
		int year = 2000;
		int month = 1;
		int day = 1;
		int ans = 0;
		while (year < 2000000) {
			day++;
			if ((year % month == 0) && (year % day == 0)) {
				ans++;
				System.out.println(year + "年" + month + "月" + day + "日");
			}
			switch (day) {
			case 29:
				if ((month == 2) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
					day = 1;
					month++;
					if ((year % month == 0) && (year % day == 0)) {
						ans++;
						System.out.println(year + "年" + month + "月" + day + "日");
					}
				}
			case 28:
				if ((month == 2) && (!(year % 4 == 0 && year % 100 != 0) || !(year % 400 == 0))) {
					day = 1;
					month++;
					if ((year % month == 0) && (year % day == 0)) {
						ans++;
						System.out.println(year + "年" + month + "月" + day + "日");
					}
				}
			case 30:
				if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
						|| month == 12)) {
					month++;
					day = 1;
					if ((year % month == 0) && (year % day == 0)) {
						ans++;
						System.out.println(year + "年" + month + "月" + day + "日");
					}
				}
			case 31:
				if (month == 4 || month == 6 || month == 9 || month == 11) {
					month++;
					day = 1;
					if ((year % month == 0) && (year % day == 0)) {
						ans++;
						System.out.println(year + "年" + month + "月" + day + "日");
					}
				}
			}
			if (month == 12) {
				year++;
				month = 1;
				if (year == 2000000) {
					break;
				}
				if ((year % month == 0) && (year % day == 0)) {
					ans++;
					System.out.println(year + "年" + month + "月" + day + "日");
				}
			}
		}
		System.out.println(ans);
	}
}