package Java_Baekjoon._13_정렬;

import java.util.Arrays;
import java.util.Scanner;

import static java.util.Collections.reverseOrder;

public class 소트인사이드 {

    /*첫째 줄에 정렬하려고 하는 수 N이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이다.
    첫째 줄에 자리수를 내림차순으로 정렬한 수를 출력한다.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String [] arr = sc.nextLine().split("");

        Arrays.sort(arr, reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(String s : arr)
            sb.append(s);

        System.out.println(sb);
    }
}
