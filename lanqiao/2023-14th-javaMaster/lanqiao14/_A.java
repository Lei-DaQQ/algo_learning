
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
 * <a href='https://blog.csdn.net/weixin_44025775/article/details/134856127'>��ʮ�Ľ����ű����������ʡ��.Java�о�����-����A:��������-CSDN����</a>
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
				System.out.println(year + "��" + month + "��" + day + "��");
			}
			switch (day) {
			case 29:
				if ((month == 2) && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
					day = 1;
					month++;
					if ((year % month == 0) && (year % day == 0)) {
						ans++;
						System.out.println(year + "��" + month + "��" + day + "��");
					}
				}
			case 28:
				if ((month == 2) && (!(year % 4 == 0 && year % 100 != 0) || !(year % 400 == 0))) {
					day = 1;
					month++;
					if ((year % month == 0) && (year % day == 0)) {
						ans++;
						System.out.println(year + "��" + month + "��" + day + "��");
					}
				}
			case 30:
				if ((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10
						|| month == 12)) {
					month++;
					day = 1;
					if ((year % month == 0) && (year % day == 0)) {
						ans++;
						System.out.println(year + "��" + month + "��" + day + "��");
					}
				}
			case 31:
				if (month == 4 || month == 6 || month == 9 || month == 11) {
					month++;
					day = 1;
					if ((year % month == 0) && (year % day == 0)) {
						ans++;
						System.out.println(year + "��" + month + "��" + day + "��");
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
					System.out.println(year + "��" + month + "��" + day + "��");
				}
			}
		}
		System.out.println(ans);
	}
}