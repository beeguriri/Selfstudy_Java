package Java_Baekjoon._23_동적계획법.복습;

import java.util.Scanner;

public class 파도반수열 {

    public static long [] dp = new long [101];

    public static long p(int n) {

        dp[1] = 1;
        dp[2] = 1;
//
//        for(int i=3; i<=n; i++)
//            dp[i] = dp[i-3] + dp[i-2];
//
//        return dp[n];

        if(n<0 || n>100)
            return 0;

        if(dp[n]!=0)
            return dp[n];

        return dp[n] = p(n-3) + p(n-2);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();



        for(int i=0; i<t; i++){

            int n = sc.nextInt();
            System.out.println(p(n));
        }

    }
}
