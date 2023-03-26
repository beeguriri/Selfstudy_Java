package Java_Baekjoon._03_반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A더하기B_5 {

    /*입력은 여러 개의 테스트 케이스로 이루어져 있다.
    각 테스트 케이스는 한 줄로 이루어져 있으며, 각 줄에 A와 B가 주어진다. (0 < A, B < 10)
    입력의 마지막에는 0 두 개가 들어온다.
    출력 : 각 테스트 케이스마다 A+B를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;

        while((str=br.readLine())!=null) {

            int a = Integer.parseInt(str.split(" ")[0]);
            int b = Integer.parseInt(str.split(" ")[1]);

            sb.append(a+b).append("\n");

        }

        System.out.println(sb);
        //테스트할때 컨트롤D!!
    }
}
