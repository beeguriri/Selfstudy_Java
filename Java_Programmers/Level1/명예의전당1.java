package Java_Programmers.Level1;

import static java.util.Collections.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 명예의전당1 {
    /*명예의 전당 목록의 점수의 개수 k, 1일부터 마지막 날까지 출연한 가수들의 점수인 score가 주어졌을 때,
    매일 발표된 명예의 전당의 최하위 점수를 return하는 solution 함수를 완성해주세요.
    * */
    public int[] solution(int k, int[] score) {
        int[] answer = new int [score.length];
        for (int i = 0; i<score.length; i++) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j =0; j<=i; j++) {
                temp.add(score[j]);
            }

            sort(temp,reverseOrder());

            if(temp.size()<=k) answer[i] = min(temp);
            else answer[i] = temp.get(k-1);
        }
        return answer;
    }

    public static void main(String[] args) {
        명예의전당1 a = new 명예의전당1();

        int [] scores1 = {10, 100, 20, 150, 1, 100, 200};
        System.out.println(Arrays.toString(a.solution(3, scores1)));; //[10, 10, 10, 20, 20, 100, 100]

        int [] scores2 = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        System.out.println(Arrays.toString(a.solution(4, scores2))); //[0, 0, 0, 0, 20, 40, 70, 70, 150, 300]

    }
}
