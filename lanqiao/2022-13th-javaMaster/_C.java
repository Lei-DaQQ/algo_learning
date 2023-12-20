import java.util.Scanner;

public class _C {

	public static void main(String[] args) {
		solve_math();
	}

	public static void solve_math() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] arr = new int[n];
		long sum = 0;
		for (int i = 0; i < n; ++i) {
			arr[i] = scanner.nextInt();
			sum += arr[i];
		}

		long res = 0;
		for (int i = 0; i < n; ++i) {
			res += arr[i] * (sum - arr[i]);
		}
		res >>= 1;
		System.out.println(res);
	}

	public static void solve_baoli() {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; ++i) {
			arr[i] = scanner.nextInt();
		}

		long res = 0;
		for (int i = 0; i < n; ++i) {
			for (int j = i + 1; j < n; ++j) {
				res += arr[i] * arr[j];
			}
		}
		System.out.println(res);
	}

}
