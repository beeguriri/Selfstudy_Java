package Java_Baekjoon._17_조합론;

import java.util.Scanner;

public class 이항계수 {

    public static long [][] dp = new long [11][11];
    public static long comb(int n, int r) {

        if(dp[n][r]!=0)
            return dp[n][r];

        else if (n==r || r==0)
            return dp[n][r] = 1;

        else
            return dp[n][r] = comb(n-1, r-1) + comb(n-1, r);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();

        System.out.println(comb(n,r));
    }
}
