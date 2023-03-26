package Java_Baekjoon._06_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평균은넘겠지 {

    /*첫째 줄에는 테스트 케이스의 개수 C가 주어진다.
    둘째 줄부터 각 테스트 케이스마다 학생의 수 N(1 ≤ N ≤ 1000, N은 정수)이 첫 수로 주어지고,
    이어서 N명의 점수가 주어진다.
    점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
    각 케이스마다 한 줄씩 평균을 넘는 학생들의 비율을 반올림하여 소수점 셋째 자리까지 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(br.readLine());

        for(int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int [] scores = new int [n];

            for(int j = 0; j < n; j++)
                scores[j] = Integer.parseInt(st.nextToken());

            int sum = 0;
            for(int s : scores)
                sum += s;

            double avg = (double) sum / n;
            int cnt = 0;
            for(int s : scores)
                if(s>avg) cnt++;

            double answer = (double) cnt/n * 100 * 1000;
            answer = Math.round(answer);

            sb.append(String.format("%.3f", answer/1000)).append("%\n");
        }
        System.out.println(sb);

    }
}
