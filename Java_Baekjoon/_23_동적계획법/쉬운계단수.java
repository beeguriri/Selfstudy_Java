package Java_Baekjoon._23_동적계획법;

import java.util.Scanner;

public class 쉬운계단수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1000000000;

        //dp[n번째자릿수][올수있는숫자]
        long [][] dp = new long [n+1][10];

        //첫번째 자리는 각 숫자마다 올수있는 경우의 수가 "1"
        //올수있는 숫자는 1~9
        for(int i=1; i<10; i++)
            dp[1][i] = 1;

        for(int i=2; i<=n; i++) {
            for(int j=0; j<10; j++) {

                if(j==0)
                    dp[i][0] = dp[i-1][1]%mod; //i번째 자리의 수가 0이면 다음 숫자는 1만 올수있음
                else if (j==9)
                    dp[i][9] = dp[i-1][8]%mod; //i번째 자리의 수가 9이면 다음 숫자는 8만 올수있음
                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1])%mod;

            }
        }

        long answer = 0;
        for(int i=0; i<10; i++)
            answer += dp[n][i];

        System.out.println(answer%mod);

    }
}
