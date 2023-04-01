package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.util.Collections.reverseOrder;

public class 커트라인 {

    /*첫째 줄에는 응시자의 수 N과 상을 받는 사람의 수 k가 공백을 사이에 두고 주어진다.
    둘째 줄에는 각 학생의 점수 x가 공백을 사이에 두고 주어진다.
    상을 받는 커트라인을 출력하라. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        List<Integer> scores = new ArrayList<>();
        for(int i = 0 ; i < n; i ++)
            scores.add(Integer.parseInt(st.nextToken()));

        scores.sort(reverseOrder());
        System.out.println(scores.get(k-1));

    }

}
