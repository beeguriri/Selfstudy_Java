package Java_Baekjoon._05_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 숫자의합 {

    /*첫째 줄에 숫자의 개수 N (1 ≤ N ≤ 100)이 주어진다.
    둘째 줄에 숫자 N개가 공백없이 주어진다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long answer = 0;
        for(int i = 0; i<n; i++)
            answer += str.charAt(i) - '0';

        System.out.println(answer);
    }
}
