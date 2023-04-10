package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _30 {

    /* 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.
    N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.
    미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라.
    그 수가 존재하지 않는다면, -1을 출력하라. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int [] numbers = new int [s.length()];
        int sum = 0;

        for(int i=0; i<s.length(); i++) {
            numbers[i] = Integer.parseInt(s.substring(i, i+1));
            sum += numbers[i];
        }

        if(!s.contains("0") || sum%3!=0) {
            System.out.println(-1);
            return;
        }

        Arrays.sort(numbers);
        StringBuilder sb = new StringBuilder();
        for(int i=numbers.length-1; i>=0; i--)
            sb.append(numbers[i]);

        System.out.println(sb);

    }

}
