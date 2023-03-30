package Java_Baekjoon._11_브루트포스;

import java.util.Scanner;

public class 수학은비대면강의입니다 {

    /*정수 a, b, c, d, e, f 가 공백으로 구분되어 차례대로 주어진다.
    (-999<=a,b,c,d,e,f<=999)
    문제에서 언급한 방정식을 만족하는 (x,y)가 유일하게 존재하고,
    이 때 x, y가 각각 -999 <= x, y <= 999 정수인 경우만 입력으로 주어짐이 보장된다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        int x = -999, y = -999;

        for(int i = -999; i<=999; i++){
            for(int j = -999; j<=999; j++) {
                if((a*i + b*j == c) && (d*i + e*j == f)) {
                    x = i;
                    y = j;
                }
            }
        }

        System.out.println(x + " " + y);

    }

}
