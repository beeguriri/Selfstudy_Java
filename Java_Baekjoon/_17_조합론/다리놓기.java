package Java_Baekjoon._17_조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 다리놓기 {

    public static long [][] dp = new long [30][30];

    public static long combination(int n, int r) {

        if(dp[n][r]!=0)
            return dp[n][r];
        else if (n==r || r==0)
            return dp[n][r]=1;
        else
            return dp[n][r] = combination(n-1,r-1) + combination(n-1, r);

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
             st = new StringTokenizer(br.readLine());
             int r = Integer.parseInt(st.nextToken());
             int n = Integer.parseInt(st.nextToken());
             sb.append(combination(n,r)).append("\n");
        }

        System.out.print(sb);




    }
}
