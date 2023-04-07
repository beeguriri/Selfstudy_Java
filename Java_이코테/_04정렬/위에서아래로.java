package Java_이코테._04정렬;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 위에서아래로 {

    /*첫째줄에 수열에 속해있는 수의 개수 n
    * 둘때줄부터 수가 입력
    * 내림차순으로 정렬된 결과 출력 */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Integer [] arr = new Integer[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr, Collections.reverseOrder());

        for(int i: arr)
            System.out.println(i);

    }
}
