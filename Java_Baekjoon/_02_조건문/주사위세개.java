package Java_Baekjoon._02_조건문;

import java.util.Arrays;
import java.util.Scanner;

public class 주사위세개 {

    /*같은 눈이 3개가 나오면 10,000원+(같은 눈)×1,000원의 상금을 받게 된다.
    같은 눈이 2개만 나오는 경우에는 1,000원+(같은 눈)×100원의 상금을 받게 된다.
    모두 다른 눈이 나오는 경우에는 (그 중 가장 큰 눈)×100원의 상금을 받게 된다.  */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int [] arr = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
        Arrays.sort(arr);

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];

        if(a==b && a==c)
            System.out.println(10000 + a*1000);
        else if (a==b || a==c || b==c) {
            if (a == b)
                System.out.println(1000 + a * 100);
            else if (a == c)
                System.out.println(1000 + a * 100);
            else System.out.println(1000 + b * 100);
        }
        else
            System.out.println(c*100);

    }
}
