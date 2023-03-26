package Java_Baekjoon._04_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균 {

    /*일단 세준이는 자기 점수 중에 최댓값을 골랐다. 이 값을 M이라고 한다.
    그리고 나서 모든 점수를 점수/M*100으로 고쳤다.
    세준이의 성적을 위의 방법대로 새로 계산했을 때,
    새로운 평균을 구하는 프로그램을 작성하시오.
    첫째 줄에 새로운 평균을 출력한다.
    실제 정답과 출력값의 절대오차 또는 상대오차가 10-2 이하이면 정답이다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] score = new int [n];
        for(int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            max = Math.max(max, x);
            score[i] = x;
        }

        double total = 0;
        for(int s : score)
            total += (double) s / max * 100;

        System.out.println(total/n);


    }
}
