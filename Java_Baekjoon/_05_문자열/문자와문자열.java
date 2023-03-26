package Java_Baekjoon._05_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자와문자열 {

    /*단어 S와 정수 i가 주어졌을 때, S의 i번째 글자를 출력하는 프로그램을 작성하시오.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int i = Integer.parseInt(br.readLine());

        System.out.println(str.charAt(i-1));
        System.out.println(str.length());
    }
}
