package Java_Baekjoon._03_반복문;

import java.util.Scanner;

public class 구구단 {
    /*N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하시오. 출력 형식에 맞춰서 출력하면 된다.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = sc.nextInt();

        for(int i = 1; i <= 9; i++) {

            sb.append(n).append(" * ").append(i).append(" = ").append(n*i).append("\n");
        }

        System.out.println(sb);
    }
}
