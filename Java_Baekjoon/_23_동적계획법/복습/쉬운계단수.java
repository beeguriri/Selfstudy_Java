package Java_Baekjoon._23_동적계획법.복습;

import java.util.Scanner;

public class 쉬운계단수 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mod = 1000000000;

        int [][] dp = new int [n+1][10]; //n번째 자릿수에 올수있는 숫자의 경우의 수

        //첫번째 자릿수에 올수있는 숫자의 경우의 수 1
        //첫번째 자리에 0이 올수없으니까 1~9만
        for(int i=1; i<=9; i++)
            dp[1][i] = 1;

        for(int i=2; i<=n; i++) {
            for (int j = 0; j <= 9; j++) {

                if (j==0)
                    dp[i][0] = dp[i-1][1] % mod;

                else if (j==9)
                    dp[i][9] = dp[i-1][8] % mod;

                else
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
            }
        }

        long answer = 0;
        for(int i=0; i<=9; i++)
            answer += dp[n][i];

        System.out.println(answer);
    }
}
