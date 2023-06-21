package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 부녀회장이될거야 {

    public static int [][] dp = new int [15][15];
    public static void dynamic(int x, int y){

        for(int i=1; i<=x; i++){
            for(int j=1; j<=y; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = Integer.parseInt(br.readLine());

        for(int i=1; i<=14; i++)
            dp[0][i] = i;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<c; i++){
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            dynamic(x, y);
            sb.append(dp[x][y]).append("\n");
        }
        System.out.print(sb);
    }
}
