package Java_Baekjoon._01_입출력과사칙연산;

import java.util.Scanner;

public class 나머지 {

    /*첫째 줄에 (A+B)%C,
    둘째 줄에 ((A%C) + (B%C))%C,
    셋째 줄에 (A×B)%C,
    넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
     */
    //5 8 4

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        sb.append((a+b)%c).append("\n");
        sb.append(((a%c) + (b%c))%c).append("\n");
        sb.append((a*b)%c).append("\n");
        sb.append(((a%c) * (b%c))%c).append("\n");

        System.out.println(sb);

    }
}
