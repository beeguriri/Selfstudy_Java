package Java_Baekjoon._23_동적계획법.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안녕 {

    public static int n,k;
    public static int [] minus; //잃는체력
    public static int [] plus; //얻는기쁨
    public static int [][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = 99;

        minus = new int [n+1];
        plus = new int [n+1];
        dp = new int [k+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            minus[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            plus[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=k; i++){
            for(int j=1; j<=n; j++){
                if(i<minus[j])
                    dp[i][j] = dp[i][j-1];
                else
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-minus[j]][j-1]+plus[j]);
            }
        }

        System.out.println(dp[k][n]);
    }
}
