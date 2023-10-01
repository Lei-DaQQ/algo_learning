import java.util.Scanner;
//http://118.190.20.162/view.page?gpid=T160
public class _1œ÷÷µº∆À„ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double i = sc.nextDouble();
		int [] profit = new int[n+1];
		double res = 0;
		for(int j = 0; j < n + 1; ++j)
		{
			
			profit[j] = sc.nextInt();
			res += profit[j] * Math.pow(1+i,-j);
		}
		System.out.println(res);
	}
}

