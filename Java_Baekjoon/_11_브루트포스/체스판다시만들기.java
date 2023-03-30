package Java_Baekjoon._11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시만들기 {

    /*첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다.
    둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
    첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String [][] board = new String[n][m];
        for(int i =0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j<m; j++) {
                board[i][j] = s.substring(j,j+1);
            }
        }

        String [][] boardW = new String[8][8];
        String [][] boardB = new String[8][8];

        String boardStr;
        //0,0이 W인 board
        for(int i = 0; i<8; i++) {
            if(i%2 == 0)
                boardStr = "WBWBWBWB";
            else
                boardStr = "BWBWBWBW";

            for(int j = 0; j<8; j++) {
                    boardW[i][j] = boardStr.substring(j,j+1);
            }
        }

        //0,0이 B인 board
        for(int i = 0; i<8; i++) {
            if(i%2 == 0)
                boardStr = "BWBWBWBW";
            else
                boardStr = "WBWBWBWB";

            for(int j = 0; j<8; j++) {
                boardB[i][j] = boardStr.substring(j,j+1);
            }
        }

        int cntMin = Integer.MAX_VALUE;
        int cntW = 0;
        int cntB = 0;

        for(int i =0; i<=n-8; i++) {
            for(int j = 0; j<=m-8; j++) {

                //8*8 체스판 순회
                for(int x= i; x<i+8; x++) {
                    for(int y = j; y<j+8; y++) {
                        if(!board[x][y].equals(boardW[x-i][y-j]))
                            cntW++;
                        if(!board[x][y].equals(boardB[x-i][y-j]))
                            cntB++;
                    }
                }

                cntMin = Math.min(cntMin, Math.min(cntW, cntB));
                cntW=0; cntB=0;

            }
        }
        System.out.println(cntMin);
    }
}
