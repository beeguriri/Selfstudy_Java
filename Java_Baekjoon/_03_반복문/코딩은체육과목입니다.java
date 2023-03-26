package Java_Baekjoon._03_반복문;

import java.util.Scanner;

public class 코딩은체육과목입니다 {

    /*첫 번째 줄에는 문제의 정수 N이 주어진다. (4<= N <=1000, N은 4의 배수)
      N바이트 정수까지 저장할 수 있다고 생각하는 정수 자료형의 이름을 출력하여라.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() / 4;

        String s = "long ".repeat(n);
        s += "int";

        System.out.println(s);
    }
}
