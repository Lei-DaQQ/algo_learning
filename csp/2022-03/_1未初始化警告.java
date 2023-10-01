import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * @author ljx
 * @date   2023-3-8 10:35:13
 * @email  ljx.1024@outlook.com
 */
public class _1Î´³õÊ¼»¯¾¯¸æ {
	public static void main(String[] args) {
		int n, k;
		int[] asn;
		
		Set<Integer> havInit = new TreeSet<Integer>();
		
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		k = sc.nextInt();
		asn = new int[k * 2];
		int notInit = 0;
		for (int i = 0; i < k; ++i) {
			int l, r;
			l = sc.nextInt();
			r = sc.nextInt();
			if(r == 0 || havInit.contains(r)) {
			}else {
				notInit ++;
			}
			havInit.add(l);
		}
		System.out.println(notInit);
	}
}
