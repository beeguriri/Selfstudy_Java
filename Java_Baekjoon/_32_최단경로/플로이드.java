package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 플로이드 {

    public static final int INF = 100000*100;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        //board 초기화
        // 모든칸을 INF로 채운 후, 자기자신(대각선)은 0으로 채움
        int [][] board = new int [n+1][n+1];

        for(int i=0; i<=n; i++)
            Arrays.fill(board[i], INF);

        for(int i=0; i<=n; i++)
            for(int j=0; j<=n; j++)
                if(i==j)
                    board[i][j] = 0;

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[a][b] = Math.min(board[a][b], c);
        }

        for(int k=1; k<=n; k++)
            for(int a=1; a<=n; a++)
                for(int b=1; b<=n; b++)
                    board[a][b] = Math.min(board[a][b], board[a][k]+board[k][b]);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++) {
                if(board[i][j]==INF)
                    sb.append(0).append(" ");
                else
                    sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}

