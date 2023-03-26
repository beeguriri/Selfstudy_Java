package Java_Baekjoon._03_반복문;

import java.io.*;
import java.util.StringTokenizer;

public class A더하기B_7 {
    /*첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
    각 테스트 케이스마다 "Case #x: "를 출력한 다음, A+B를 출력한다. 테스트 케이스 번호는 1부터 시작한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int i = 1; i <= t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int sum = a+b;
            bw.write("Case #" + i + ": " + a + " + " + b + " = " + sum + "\n");
        }
        bw.flush();
        bw.close();

    }
}
