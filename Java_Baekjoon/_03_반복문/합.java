package Java_Baekjoon._03_반복문;

import java.util.Scanner;

public class 합 {

    /*n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;

        for(int i = 1; i <= n; i++)
            sum += i;

        System.out.println(sum);
    }
}
