package Java_Baekjoon._23_동적계획법;

import java.util.Scanner;

public class _2n타일링 {

    public static int [] dp = new int [1001];

    public static int findValue(int n) {

        if(n<0 || n>1000)
            return 0;

        if (n>=1 && n<=1000 && dp[n]!=0)
            return dp[n];

        if(n==1)
            return 1;

        if(n==2)
            return 2;

        return dp[n] = (findValue(n-1) + findValue(n-2)) % 10007;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        dp[1] = 1;
//        dp[2] = 2;
//
//        for(int i=3; i<=n; i++) {
//            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
//        }
//
//        System.out.println(dp[n]);

        System.out.println(findValue(n));
    }
}
