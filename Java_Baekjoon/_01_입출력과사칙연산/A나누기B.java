package Java_Baekjoon._01_입출력과사칙연산;

import java.util.Scanner;

public class A나누기B {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double a = sc.nextInt();
        double b = sc.nextInt();
        double answer = a/b * 100000000 / 100000000;

        System.out.println(answer);
    }

}


