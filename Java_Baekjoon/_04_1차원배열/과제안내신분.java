package Java_Baekjoon._04_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 과제안내신분 {

    /*교실엔 학생이 30명이 있는데, 학생 명부엔 각 학생별로 1번부터 30번까지 출석번호가 붙어 있다.
    교수님이 내준 특별과제를 28명이 제출했는데,
    그 중에서 제출 안 한 학생 2명의 출석번호를 구하는 프로그램을 작성하시오.
    입력은 총 28줄로 각 제출자(학생)의 출석번호 n(1 ≤ n ≤ 30)가 한 줄에 하나씩 주어진다. 출석번호에 중복은 없다.
    출력은 2줄이다. 1번째 줄엔 제출하지 않은 학생의 출석번호 중 가장 작은 것을 출력하고,
    2번째 줄에선 그 다음 출석번호를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean [] check = new boolean[30];

        for(int i = 0; i< 28; i++) {
            int x = Integer.parseInt(br.readLine());
            check[x-1] = true;
        }

        for(int i = 0; i<30; i++){
            if (!check[i]) System.out.println(i+1);
        }
    }
}
