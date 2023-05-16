package Java_Baekjoon._23_동적계획법.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 신나는함수실행 {

    public static int [][][] dp = new int [21][21][21];

    public static int w(int a, int b, int c) {

        if(a>=0 && b>=0 && c>=0 && a<=20 && b<=20 && c<=20 && dp[a][b][c]!=0)
            return dp[a][b][c];

        if(a<=0 || b<=0 || c<=0)
            return 1;

        if(a>20 || b>20 || c>20)
            return dp[20][20][20] = w(20, 20, 20);

        if(a<b && b<c)
            return dp[a][b][c] = w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);

        else
            return dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        while(!s.equals("-1 -1 -1")) {

            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            int c = Integer.parseInt(s.split(" ")[2]);

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ").append(w(a,b,c)).append("\n");
            //시간초과
            //System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a,b,c));

            s = br.readLine();
        }

        System.out.println(sb);

    }
}
