package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 대표값2 {

    /*다섯 개의 자연수가 주어질 때 이들의 평균과 중앙값을 구하는 프로그램을 작성하시오.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int [] arr = new int [5];

        for(int i = 0; i < 5; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int avg = 0;

        for(int i : arr)
            avg += i;

        System.out.println(avg/5);
        System.out.println(arr[2]);


    }
}
