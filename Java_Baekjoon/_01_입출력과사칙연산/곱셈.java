package Java_Baekjoon._01_입출력과사칙연산;

import java.util.Scanner;

public class 곱셈 {

    /*입력 : 첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
      출력 : 첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int a = sc.nextInt();
        int b = sc.nextInt();

        String strB = String.valueOf(b);

        for(int i = 0; i < strB.length(); i++) {
            int x = Integer.parseInt(strB.split("")[strB.length()-i-1]);
            sb.append(a*x).append("\n");
        }
        sb.append(a*b);
        System.out.println(sb);
    }
}
