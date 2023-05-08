package Java_Baekjoon._23_동적계획법;

import java.util.Scanner;

public class _01타일 {

    public static long dp [] = new long [1000001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++)
            dp[i] = (dp[i-1] + dp[i-2])%15746;

        System.out.println(dp[n]);

    }
}
