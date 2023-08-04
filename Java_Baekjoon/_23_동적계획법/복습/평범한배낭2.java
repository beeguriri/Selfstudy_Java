package Java_Baekjoon._23_동적계획법.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭2 {

    public static int n, k;
    public static int [] w;
    public static int [] v;
    public static int [][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        w = new int [n+1];
        v = new int [n+1];
        dp = new int [k+1][n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            w[i] = Integer.parseInt(st.nextToken());
            v[i] = Integer.parseInt(st.nextToken());
        }

        //무게에 대한 개수를 탐색
        for(int i=1; i<=k; i++) {
            for(int j=1; j<=n; j++){

                if(i<w[j])
                    dp[i][j] = dp[i][j-1];

                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-w[j]][j-1] + v[j]);

            }
        }

        System.out.println(dp[k][n]);
    }
}
