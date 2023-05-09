package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 파도반수열 {

    public static long [] dp = new long [101];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {

            int n = Integer.parseInt(br.readLine());

            for(int j=4; j<=n; j++)
                dp[j] = dp[j-3] + dp[j-2];

            System.out.println(dp[n]);

        }

    }
}
