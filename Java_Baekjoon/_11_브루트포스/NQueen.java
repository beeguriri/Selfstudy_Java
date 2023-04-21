package Java_Baekjoon._11_브루트포스;

import java.util.Scanner;

public class NQueen {

    public static int cnt=0;
    public static int n;
    public static int [][] board;

    public static void solveQ(int row){

        if(row==n){
            cnt++;
            return;
        }

        for(int col=0; col<n; col++){
            if(isPossible(row,col)) {
                board[row][col] = 1;
                solveQ(row+1);
                board[row][col] = 0;
            }
        }
    }

    public static boolean isPossible(int row, int col) {

        //row 확인
        for(int i=0; i<row; i++)
            if(board[i][col]==1)
                return false;

        //column 확인
        for(int i=0; i<col; i++)
            if(board[row][i]==1)
                return false;

        //오른쪽 대각선 확인
        for(int i=row, j=col; i>=0 && j<n; i--, j++){
            if(board[i][j]==1)
                return false;
        }

        //왼쪽 대각선 확인
        for(int i=row, j=col; i>=0 && j>=0; i--, j--){
            if(board[i][j]==1)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        board = new int [n][n];
        solveQ(0);
        System.out.println(cnt);
    }
}
