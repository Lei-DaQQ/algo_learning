
/*
 * @author ljx
 * @date   Dec 20, 2023 8:44:16 PM
 * @email  ljx.1024@outlook.com
 * @Description 
 */

import java.util.*;

public class _D×Ó¾ØÕó{
    
    public static int[][] mat;
    public static int MOD = 998244353;
    public static int[][] max1, min1;
    public static int[][] max2, min2;
    public static int n, m, a, b;
    
    public static void main(String[] args){
        
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        mat = new int[n][m];
        max1 = new int[n][m];
        min1 = new int[n][m];
        
        max2 = new int[n][m];
        min2 = new int[n][m];
        
        
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                mat[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n; ++i){
            getMin1(i, b);
            getMax1(i, b);
        }
        for(int j = 0; j < m; ++j){
            getMin2(j, a);
            getMax2(j, a);
        }
        
        
        long res = 0;
        for(int i = a-1; i < n; ++i){
            for(int j = b-1; j < m; ++j){
                // System.out.println(min2[i][j] + " " + max2[i][j]);        
                long tmp = (long) min2[i][j] * max2[i][j] % MOD;
                res = (res + tmp) % MOD;
                
                
            }
        }
        System.out.println(res);
        
        
        
    }
    
    public static void getMin1(int row, int k){
        int hh = 0, tt = -1;
        int[] q = new int[m];
        int[] arr = mat[row];
        // System.out.println(1);
        for(int i = 0; i < m; ++i){
            if(hh <= tt && q[hh] + k - 1 < i) hh++;    
            while(hh <= tt && arr[i] <= arr[q[tt]]) --tt;
            q[++tt] = i;
            if(i >= k - 1){
                min1[row][i] = arr[q[hh]];
                // System.out.println(min1[row][i]);
            }
                
        }
    }
        
    public static void getMax1(int row, int k){
        int hh = 0, tt = -1;
        int[] q = new int[m];
        int[] arr = mat[row];
        for(int i = 0; i < m; ++i){
            if(hh <= tt && q[hh] + k - 1 < i) hh++;    
            while(hh <= tt && arr[i] >= arr[q[tt]]) --tt;
            q[++tt] = i;
            if(i >= k - 1)
                max1[row][i] = arr[q[hh]];
        }
    }
    
    public static void getMin2(int col, int k){
        int hh = 0, tt = -1;
        int[] q = new int[n];
        
        for(int i = 0; i < n; ++i){
            if(hh <= tt && q[hh] + k - 1 < i) hh++;    
            while(hh <= tt && min1[i][col] <= min1[q[tt]][col]) --tt;
            q[++tt] = i;
            if(i >= k - 1)
                min2[i][col] = min1[q[hh]][col];
        }
    }
    public static void getMax2(int col, int k){
        int hh = 0, tt = -1;
        int[] q = new int[n];
        
        for(int i = 0; i < n; ++i){
            if(hh <= tt && q[hh] + k - 1 < i) hh++;    
            while(hh <= tt && max1[i][col] >= max1[q[tt]][col]) --tt;
            q[++tt] = i;
            if(i >= k - 1)
                max2[i][col] = max1[q[hh]][col];
        }
    }
    
}