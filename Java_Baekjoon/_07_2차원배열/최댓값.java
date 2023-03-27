package Java_Baekjoon._07_2차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최댓값 {

    /*9×9 격자판에 쓰여진 81개의 자연수 또는 0이 주어질 때,
    이들 중 최댓값을 찾고 그 최댓값이 몇 행 몇 열에 위치한 수인지 구하는 프로그램을 작성하시오.
    첫째 줄부터 아홉 번째 줄까지 한 줄에 아홉 개씩 수가 주어진다. 주어지는 수는 100보다 작은 자연수 또는 0이다.
    첫째 줄에 최댓값을 출력하고,
    둘째 줄에 최댓값이 위치한 행 번호와 열 번호를 빈칸을 사이에 두고 차례로 출력한다.
    최댓값이 두 개 이상인 경우 그 중 한 곳의 위치를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;
        int idxR = 0;
        int idxC = 0;

        //행렬 입력
        int [][] board = new int [9][9];
        for(int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        //최대값 확인
        for(int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Math.max(max, board[i][j]) == board[i][j]) {
                    max = Math.max(max, board[i][j]);
                    idxR = i;
                    idxC = j;
                }
            }
        }

        System.out.println(max);
        System.out.println((idxR+1) + " " + (idxC+1));

    }
}
