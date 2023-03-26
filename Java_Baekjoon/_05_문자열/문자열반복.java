package Java_Baekjoon._05_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 문자열반복 {

    /*첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
    각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8),
    문자열 S가 공백으로 구분되어 주어진다.
    S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            String s = st.nextToken();
            for(int j = 0; j < s.length(); j++) {
                sb.append(s.substring(j,j+1).repeat(x));
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}
