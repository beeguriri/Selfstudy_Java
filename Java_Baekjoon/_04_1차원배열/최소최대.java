package Java_Baekjoon._04_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class 최소최대 {

    /*N개의 정수가 주어진다. 이때, 최솟값과 최댓값을 구하는 프로그램을 작성하시오.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i = 0; i <n; i++) {
            int x = Integer.parseInt(st.nextToken());
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        System.out.println(min + " " + max);
    }
}
