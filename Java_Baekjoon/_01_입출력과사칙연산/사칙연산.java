package Java_Baekjoon._01_입출력과사칙연산;

import java.util.Scanner;

public class 사칙연산 {

    /*첫째 줄에 A+B, 둘째 줄에 A-B,
    셋째 줄에 A*B, 넷째 줄에 A/B, 다섯째 줄에 A%B를 출력한다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        sb.append(a+b).append("\n");
        sb.append(a-b).append("\n");
        sb.append(a*b).append("\n");
        sb.append(a/b).append("\n");
        sb.append(a%b).append("\n");

        System.out.println(sb);
    }
}
