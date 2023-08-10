package Java_Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 마인크래프트 {

    //‘땅 고르기’ 작업에 걸리는 최소 시간과 그 경우 땅의 높이를 출력하시오.
    public static int m,n;
    public static int b;
    public static int [][] board;

    public static int [] checkBoard(int target) {

        int plus  = 0; // 블럭 높이 높여야함
        int minus = 0; // 블럭 높이 낮춰야함

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]<target)
                    plus += (target-board[i][j]);
                else if(board[i][j]>target)
                    minus += (board[i][j]-target);
            }
        }

        return new int [] {plus, minus};
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> block = new ArrayList<>();

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        board = new int [m][n];

        int min = 256;
        int max = 0;

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(min, board[i][j]);
                max = Math.max(max, board[i][j]);
            }
        }

        //전체 순회
        int totalTime = Integer.MAX_VALUE;

        for(int target=min; target<=max; target++) {

            //plus : 블럭높이 높이기 => 1초
            //minus : 블록높이 낮추기 => 2초
            //{plus, minus}
            int [] answer = checkBoard(target);
            if(b + answer[1] < answer[0])
                continue;

            int time = answer[0] + answer[1]*2;

            if(time<=totalTime) {
                totalTime = time;
                block.add(target);
            }
        }

        System.out.print(totalTime + " ");
        block.sort(Collections.reverseOrder());
        System.out.print(block.get(0));

    }
}
