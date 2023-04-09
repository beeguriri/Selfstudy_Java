package Java_Baekjoon._27_이분탐색;

import java.util.Scanner;

public class 게임 {

    /*게임 횟수 : X
    이긴 게임 : Y (Z%)
    1 ≤ X ≤ 1,000,000,000 , 0 ≤ Y ≤ X
    Z는 형택이의 승률이고, 소수점은 버린다.
    X와 Y가 주어졌을 때, 형택이가 게임을 최소 몇 번 더 해야 Z가 변하는지 구하는 프로그램을 작성하시오. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long x = sc.nextLong();
        long y = sc.nextLong();

        long start = 0;
        long end = 1000000000;
        double target = Math.floor(y*100 /x);
        long result = Integer.MAX_VALUE;

        while(start <= end){

            long mid = (start + end) /2;
            double winning = 0;

            winning = Math.floor((y+mid)*100 / (x+mid));

            if((long)winning <= (long)target)
                start = mid + 1;
            else {
                end = mid - 1;
                result = Math.min(result, mid);
            }

        }

        if(result!=Integer.MAX_VALUE)
            System.out.println(result);
        else
            System.out.println("-1");

    }
}
