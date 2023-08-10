package Java_Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 사탕게임 {

    public static int n;
    public static char [][] board;
    public static int max;

    public static void swap(int r1, int c1, int r2, int c2){
        char temp = board[r1][c1];
        board[r1][c1] = board[r2][c2];
        board[r2][c2] = temp;
    }

    public static void countCandy() {

        //가장 긴 연속하는 부분 행
        for(int i=0; i<n; i++) {
            int count=1;
            for(int j=0; j<n-1; j++) {
                if(board[j][i]==board[j+1][i])
                    count++;
                else
                    count=1;
                max = Math.max(max, count);
            }
        }

        //가장 긴 연속하는 부분 열
        for(int i=0; i<n; i++) {
            int count=1;
            for(int j=0; j<n-1; j++) {
                if(board[i][j]==board[i][j+1])
                    count++;
                else
                    count=1;
                max = Math.max(max, count);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for(int i=0; i<n; i++)
            board[i] = br.readLine().toCharArray();

        //max에 기본상태일때의 값 저장
        countCandy();

        //행으로 글자 하나씩 바꿔가며 확인
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {
                if(board[j][i]!=board[j+1][i]) {
                    swap(j, i, j+1, i);
                    countCandy();
                    swap(j+1, i, j, i);
                }
            }
        }

        //열로 글자 하나씩 바꿔가며 확인
        for(int i=0; i<n; i++) {
            for(int j=0; j<n-1; j++) {
                if(board[i][j]!=board[i][j+1]) {
                    swap(i, j, i, j+1);
                    countCandy();
                    swap(i, j+1, i, j);
                }
            }
        }

        System.out.println(max);

    }
}
