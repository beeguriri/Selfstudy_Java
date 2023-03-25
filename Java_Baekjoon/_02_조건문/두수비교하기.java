package Java_Baekjoon._02_조건문;

import java.util.Scanner;

public class 두수비교하기 {

    /*첫째 줄에 A와 B가 주어진다. A와 B는 공백 한 칸으로 구분되어져 있다.
    A가 B보다 큰 경우에는 '>'를 출력한다.
    A가 B보다 작은 경우에는 '<'를 출력한다.
    A와 B가 같은 경우에는 '=='를 출력한다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        if(a>b) System.out.println(">");
        else if(a<b) System.out.println("<");
        else System.out.println("==");


    }
}
