package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 수정렬하기3 {

    /*첫째 줄에 수의 개수 N(1 ≤ N ≤ 10,000,000)이 주어진다.
    둘째 줄부터 N개의 줄에는 수가 주어진다. 이 수는 10,000보다 작거나 같은 자연수이다.
    첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //list형은 메모리 초과
        int [] arr = new int [n];
        for(int i = 0; i < n ; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        //system out은 시간초과
        StringBuilder sb = new StringBuilder();
        for(int i : arr)
            sb.append(i).append("\n");

        System.out.println(sb);

    }
}

