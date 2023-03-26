package Java_Baekjoon._05_문자열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 문자열 {

    /*문자열을 입력으로 주면 문자열의 첫 글자와 마지막 글자를 출력하는 프로그램을 작성하시오.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.length()==1)
                sb.append(s).append(s).append("\n");
            else
                sb.append(s.charAt(0)).append(s.charAt(s.length()-1)).append("\n");
        }
        System.out.println(sb);

    }
}
