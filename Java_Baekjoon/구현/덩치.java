package Java_Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 덩치 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] board = new int [n][2];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
        }

        int [] answer = new int [n];

        for(int i=0; i<n; i++){
            int order = 1;
            for(int j=0; j<n; j++){
                if(i==j)
                    continue;

                if(board[i][0]<board[j][0] && board[i][1]<board[j][1])
                    order++;
            }
            answer[i] = order;
        }

        StringBuilder sb = new StringBuilder();
        for(int i : answer)
            sb.append(i).append(" ");
        System.out.println(sb);
    }
}
