package Java_이코테._01그리디;

import java.util.Scanner;

public class 숫자게임 {

    /* N x M 행렬 입력받아서
    * 각 행에서 제일 작은 숫자중 제일 큰수 뽑기*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("m, n 입력 : ");
        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println("mxn행렬 입력 : ");
        //int [][] matrix = new int [m][n];
        int answer = 0;
        for(int i = 0; i<m; i++) {
            //현재 줄에서 가장 작은 값 찾기
            int min_value = Integer.MAX_VALUE;
            for(int j = 0; j<n; j++) {
                int x = sc.nextInt();
                min_value = Math.min(min_value, x);
            }
            answer = Math.max(answer, min_value);
        }
        System.out.println(answer);
            //입력 받을때 확인
//        int col = Integer.MAX_VALUE; //각 행에서 제일 작은값
//        int row = Integer.MIN_VALUE; //각 행의 값들 중 제일 큰 값
//        for(int i = 0; i<m; i++) {
//            for(int j = 0; j<n; j++) {
//                col = Math.min(col, matrix[i][j]);
//            }
//            row = Math.max(row, col);
//            col = Integer.MAX_VALUE;
//        }

        //3x3
        //312|414|222

        //2x4
        //7318|3334
    }
}
