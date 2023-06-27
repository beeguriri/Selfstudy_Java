package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 안녕 {

    public static int n;
    public static int k = 99;
    public static int [] minus;
    public static int [] plus;
    public static int [][] dp;

    public static int backpack() {

        for(int i=1; i<=k; i++) { //체력 탐색
            for(int j=1; j<=n; j++) { //각 사람 탐색

                //i<w : 물건 못넣음
                if(i<minus[j])
                    dp[i][j] = dp[i][j-1];

                //배낭에 물건 추가
                //dp[i-w][j-1] + 현재단계가치 vs 이전단계 가치
                else
                    dp[i][j] = Math.max(dp[i-minus[j]][j-1]+plus[j], dp[i][j-1]);
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        minus = new int [n+1];
        plus = new int [n+1];
        dp = new int [k+1][n+1];

        StringTokenizer st =  new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            minus[i] = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            plus[i] = Integer.parseInt(st.nextToken());

        System.out.println(backpack());

        for(int [] i : dp)
            System.out.println(Arrays.toString(i));

    }
}
