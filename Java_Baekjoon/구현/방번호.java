package Java_Baekjoon.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 방번호 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        int [] board = new int [10];

        for(int i=0; i<num.length(); i++){
            int n = Integer.parseInt(num.substring(i, i+1));
            //6은 9를 뒤집어서, 9는 6을 뒤집어서 쓸수있다.
            //661 -> set2개
            //6661 -> set3개
            //6699 -> set2개
            if(n==6){
                board[9] += 1;
            } else {
                board[n] += 1;
            }
        }

        if(board[9]%2==0)
            board[9] /= 2;
        else
            board[9] = (board[9]/2)+1;

        int size = 0;
        for(int i : board)
            size = Math.max(size, i);

        System.out.println(Arrays.toString(board));
        System.out.println(size);
    }
}
