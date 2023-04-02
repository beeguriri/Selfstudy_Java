package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 바닥장식 {

    /*이제 ‘-’와 ‘|’로 이루어진 바닥 장식 모양이 주어진다.
    만약 두 개의 ‘-’가 인접해 있고, 같은 행에 있다면, 두 개는 같은 나무 판자이고,
    두 개의 ‘|’가 인접해 있고, 같은 열에 있다면, 두 개는 같은 나무 판자이다.
    입력 : 첫째 줄에 방 바닥의 세로 크기N과 가로 크기 M이 주어진다.
    둘째 줄부터 N개의 줄에 M개의 문자가 주어진다.
    이것은 바닥 장식 모양이고, '-‘와 ’|‘로만 이루어져 있다.
    N과 M은 50 이하인 자연수이다.
    출력 : 첫째 줄에 문제의 정답을 출력한다.*/

    public static int n, m;
    public static int [][] board;
    public static boolean [][] visited;

    public static void searchBoard(int x, int y, boolean row) {

        visited[x][y] = true;
        //행만 검사
        if(row) {
            y++;
            if(y<m && board[x][y]==0)
                searchBoard(x,y,true);
        }
        //열만 검사
        else {
            x++;
            if(x<n && board[x][y]==1)
                searchBoard(x,y,false);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();
        n = Integer.parseInt(size.split(" ")[0]);
        m = Integer.parseInt(size.split(" ")[1]);

         board = new int [n][m];
         visited = new boolean [n][m];

        // "-" -> 0, "|" -> 1
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            for(int j = 0; j<m; j++) {
                board[i][j] = s.charAt(j) == '-' ? 0 : 1;
            }
        }

        //탐색
        int cnt = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(visited[i][j]) continue;

                // 0이면 행만 검사
                if(board[i][j] == 0)
                    searchBoard(i, j, true);

                //1이면 열만 검사
                else
                    searchBoard(i, j, false);

                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
