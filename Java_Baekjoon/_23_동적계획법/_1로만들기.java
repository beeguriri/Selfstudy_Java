package Java_Baekjoon._23_동적계획법;

import java.util.Scanner;

public class _1로만들기 {

    public static long [] dp = new long [1000001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp[1] = 0;

        for(int i=2; i<=n; i++){

            dp[i] = dp[i-1]+1;

            if(i%3==0)
                dp[i] = Math.min(dp[i], dp[i/3]+1);

            if(i%2==0)
                dp[i] = Math.min(dp[i], dp[i/2]+1);

        }

        System.out.println(dp[n]);

    }
}
