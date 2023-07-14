package Java_Programmers.Level2;

import java.util.Arrays;

public class 삼각달팽이 {

    public static int[] solution(int n) {
        int[] answer = new int [n*(n+1)/2];
        int [][] board = new int[n][n];

        int x=-1; int y=0;
        int num = 1;
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(i%3==0)
                    x++;
                else if(i%3==1)
                    y++;
                else {
                    x--;
                    y--;
                }
                board[x][y] = num++;
            }
        }

        int idx=0;
        for(int i=0; i<n; i++)
            for (int j=0; j<n; j++)
                if (board[i][j]!=0)
                    answer[idx++] = board[i][j];

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
    }
}
