package Java_Programmers.Level3;

import java.util.Arrays;

public class P_07 {

    /*
        등굣길
        최단거리의 개수(!!!) 구하기!
        오른쪽과 아래로만 이동
        m : 열, n : 행, [m, n] 웅덩이 위치
     */

    public static long solution(int m, int n, int[][] puddles) {

        int mod = 1_000_000_007;
        long [][] board = new long [n+1][m+1];

        for(int [] puddle : puddles)
            board[puddle[1]][puddle[0]] = -1;

        board[1][1] = 1;
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){

                if(board[i][j]==-1)
                    continue;

                if(board[i-1][j]!=-1)
                    board[i][j] += board[i-1][j];
                
                if(board[i][j-1]!=-1)
                    board[i][j] += board[i][j-1];

                board[i][j] %= mod;
            }
        }

        return board[n][m]%mod;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 3, new int [][] {{2,2}}));

    }
}
