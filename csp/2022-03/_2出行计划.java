import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/*
 * @author ljx
 * @date   2023-3-8 10:52:39
 * @email  ljx.1024@outlook.com
 */
public class _2出行计划 {
	public static void main(String[] args) {
		int n, m, k;
		int [] inStart, inEnd;
		rnaTime[] place;
		int [] req;
		
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		
//		inStart = new int[n];
		inEnd = new int[n];
//		
		place = new rnaTime[n];
		req = new int [m];
		
		for(int i = 0; i < n; ++i)
		{
			int t, c;
			t = sc.nextInt();
			c = sc.nextInt();
			place[i] = new rnaTime(t-c+1, t);
//			inStart[i] = t - c;
			inEnd[i] =  t;
		}
		
		Arrays.sort(place);
		Arrays.sort(inEnd);
		
		int stPointer = 0, enPointer = 0;
		int ans = 0;
		for(int i = 0; i < m; ++i)
		{
			req[i] = sc.nextInt();
			int outRstTime = req[i] + k;
			int j = stPointer;
			while(j < n && outRstTime >= place[j].startTime) {
				j++;
				ans++;
			}
			stPointer = j;
			
			//
			
			j = enPointer;
			while(j < n && outRstTime > inEnd[j]) {
				j++;
				ans--;
			}
			enPointer = j;
			
			System.out.println(ans);
		}
		/*
6 1 10
5 24
10 24
11 24
34 24
35 24
35 48
25	
		
*/
		

		
		
	}//main

}

class rnaTime implements Comparable<rnaTime>{
	int startTime, endTime;
	public rnaTime(int st, int et) {
		// TODO Auto-generated constructor stub
		this.startTime = st;
		this.endTime = et;
		
		this.startTime = Math.max(0, this.startTime);
	}
	
	public int compare(rnaTime t1, rnaTime t2)
	{
		int st = t1.startTime - t2.startTime;
		if(st != 0)
			return st;
		int en = t1.endTime - t2.endTime;
		return en;
	}
	
	public int compareTo(rnaTime t2) {
		// TODO Auto-generated method stub
		int st = this.startTime - t2.startTime;
		if(st != 0)
			return st;
		int en = this.endTime - t2.endTime;
		return en;

	}
	
	
	
	
}
