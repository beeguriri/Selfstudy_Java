package Java_Baekjoon._23_동적계획법;

import java.util.Scanner;

public class _123만들기 {

    //dp[0] = 0
    //dp[1] = 1
    //dp[2] = 2
    //dp[3] = 4 (1+1+1, 1+2, 2+1, 3)
    //dp[4] = 7

    public static int [] dp = new int [12];

    public static int dp(int x) {

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=x; i++)
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];

        return dp[x];

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for(int i=0; i<n; i++) {
            System.out.println(dp(sc.nextInt()));
        }
    }
}
