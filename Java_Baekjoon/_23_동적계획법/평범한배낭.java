package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int [][] arr = new int [n+1][2];

        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int [][] dp = new int [k+1][n+1];

        for(int i=1; i<=k; i++) {
            for(int j=1; j<=n; j++) {
                if(i<arr[j][0])
                    dp[i][j] = dp[i][j-1];
                else
                    dp[i][j] = Math.max(dp[i-arr[j][0]][j-1] + arr[j][1], dp[i][j-1]);
            }
        }

        System.out.println(dp[k][n]);

    }
}
