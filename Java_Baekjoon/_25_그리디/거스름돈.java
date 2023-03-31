package Java_Baekjoon._25_그리디;

import java.util.Scanner;

public class 거스름돈 {

    /*JOI잡화점에는 잔돈으로 500엔, 100엔, 50엔, 10엔, 5엔, 1엔이 충분히 있고,
    언제나 거스름돈 개수가 가장 적게 잔돈을 준다.
    타로가 JOI잡화점에서 물건을 사고 카운터에서 1000엔 지폐를 한장 냈을 때,
    받을 잔돈에 포함된 잔돈의 개수를 구하는 프로그램을 작성하시오.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = 1000 - a;
        int cnt = 0;

        int [] coins = {500, 100, 50, 10, 5, 1};

        for(int c : coins) {
            cnt += n/c;
            n = n%c;
        }
        System.out.println(cnt);
        //380 4
        //1 15
    }
}
