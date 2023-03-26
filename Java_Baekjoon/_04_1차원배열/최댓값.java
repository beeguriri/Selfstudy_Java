package Java_Baekjoon._04_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 최댓값 {

    /*첫째 줄부터 아홉 번째 줄까지 한 줄에 하나의 자연수가 주어진다. 주어지는 자연수는 100 보다 작다.
    첫째 줄에 최댓값을 출력하고, 둘째 줄에 최댓값이 몇 번째 수인지를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = Integer.MIN_VALUE;
        int idx = 0;

        int [] arr = new int [9];

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max,arr[i]);
            if(arr[i]==max) idx = i+1;
        }

        System.out.println(max);
        System.out.println(idx);

    }
}
