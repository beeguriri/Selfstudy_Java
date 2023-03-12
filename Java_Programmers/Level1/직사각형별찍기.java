package Java_Programmers.Level1;

import java.util.Scanner;

public class 직사각형별찍기 {

    /* 이 문제에는 표준 입력으로 두 개의 정수 n과 m이 주어집니다.
        별(*) 문자를 이용해 가로의 길이가 n, 세로의 길이가 m인 직사각형 형태를 출력해보세요.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("input n :: ");
        int n = sc.nextInt();
        System.out.print("input m :: ");
        int m = sc.nextInt();

        for(int i = 0; i<m; i++)
                System.out.println("*".repeat(n));

    }
}
