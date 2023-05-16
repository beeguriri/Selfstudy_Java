package Java_Baekjoon._23_동적계획법.복습;

import java.util.Scanner;

public class 타일 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] dp = new int [n+1];

        dp[1] = 1;

        if(n>=2)
            dp[2] = 2;

        for(int i=3; i<=n; i++)
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;

        System.out.println(dp[n]);

    }
}
