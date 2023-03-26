package Java_Baekjoon._03_반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A더하기B_3 {

    /*첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다.
    (0 < A, B < 10)
    출력 : 각 테스트 케이스마다 A+B를 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            int x = Integer.parseInt(s.split(" ")[0]);
            int y = Integer.parseInt(s.split(" ")[1]);

            sb.append(x+y).append("\n");
        }

        System.out.println(sb);

    }
}
