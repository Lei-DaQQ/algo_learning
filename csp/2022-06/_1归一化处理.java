import java.util.Scanner;

/*
 * @author ljx
 * @date   2023-3-7 10:24:57
 * @email  ljx.1024@outlook.com
 */
public class _1归一化处理 {
	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();

		int[] arr = new int[n];
		double sum = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = sc.nextInt();
			sum += arr[i];

		}
		double ave = sum / n;

		// fang ch
		double d = 0;
		for (int i = 0; i < n; ++i) {
			d += Math.pow(arr[i] - ave, 2);
		}
		d /= n;

		// output
		d = Math.sqrt(d);
		for(int i = 0; i < n; ++i)
		{
			System.out.println((arr[i]-ave)/d);
		}
		
		
	}
}
