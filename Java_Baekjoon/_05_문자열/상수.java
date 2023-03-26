package Java_Baekjoon._05_문자열;

import java.util.Scanner;

public class 상수 {

    /*첫째 줄에 상근이가 칠판에 적은 두 수 A와 B가 주어진다.
    두 수는 같지 않은 세 자리 수이며, 0이 포함되어 있지 않다.
    상수는 수를 다른 사람과 다르게 거꾸로 읽는다.
    예를 들어, 734와 893을 칠판에 적었다면, 상수는 이 수를 437과 398로 읽는다.
    따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.next();
        String b = sc.next();

        String newA ="";
        String newB ="";
        for(int i = 0; i<3; i++) {
            newA = a.charAt(i) + newA;
            newB = b.charAt(i) + newB;
        }
        System.out.println(Math.max(Integer.parseInt(newA), Integer.parseInt(newB)));
    }
}
