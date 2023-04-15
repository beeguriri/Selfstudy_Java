package Java_Baekjoon._25_그리디;

import java.util.Scanner;

public class A_B {

    /*정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
    2를 곱한다.
    1을 수의 가장 오른쪽에 추가한다.
    A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
    첫째 줄에 A, B (1 ≤ A < B ≤ 109)가 주어진다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int cnt = 1;
        while (a<=b) {

            if(b%10==1) {
                b = b / 10;
                cnt++;
            } else if (b%2==0){
                b = b / 2;
                cnt++;
            } else
                break;

            if (a==b)
                break;
        }

        if(a==b)
            System.out.println(cnt);
        else
            System.out.println(-1);
    }
}
