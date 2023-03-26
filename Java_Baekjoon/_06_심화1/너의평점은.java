package Java_Baekjoon._06_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 너의평점은 {

    /*전공평점은 전공과목별 (학점 × 과목평점)의 합을 학점의 총합으로 나눈 값이다.
    P/F 과목의 경우 등급이 P또는 F로 표시되는데, 등급이 P인 과목은 계산에서 제외해야 한다.
    20줄에 걸쳐 치훈이가 수강한 전공과목의 과목명, 학점, 등급이 공백으로 구분되어 주어진다.
    정답과의 절대오차 또는 상대오차가  10^-4 이하이면 정답으로 인정한다.*/

    public static void main(String[] args) throws IOException {

        Map<String, Double> map = new HashMap<>();
        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double total = 0;
        int cnt = 0;
        for(int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            double score = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            if(grade.equals("P"))
                continue;

            total += map.get(grade) * score;
            cnt += score;
        }
        double avg = total / cnt;
        System.out.println(avg);

    }
}
