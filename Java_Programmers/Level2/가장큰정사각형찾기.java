package Java_Programmers.Level2;

import java.util.Arrays;

public class 가장큰정사각형찾기 {

    public static int solution(int [][]board) {

        int [][] dp = new int [board.length+1][board[0].length+1];

        //dp 배열 초기화
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[0].length; j++)
                dp[i+1][j+1] = board[i][j];

        for(int [] i : dp)
            System.out.println(Arrays.toString(i));

        int max = 0;

        //왼쪽위, 위, 왼쪽 확인
        for(int i=1; i<dp.length; i++) {
            for (int j=1; j <dp[0].length; j++) {
                if (dp[i][j]!=0) {
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]))+1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }

        System.out.println("=".repeat(30));
        for(int [] i : dp)
            System.out.println(Arrays.toString(i));

        return max*max;
    }

    public static void main(String[] args) {

        System.out.println(solution(new int [][] {{0,1,1,1}, {1,1,1,1}, {1,1,1,1}, {0,0,1,0}})); // 9
        System.out.println(solution(new int [][] {{0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0}})); // 9
    }
}

