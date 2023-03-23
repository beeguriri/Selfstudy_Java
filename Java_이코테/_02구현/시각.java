package Java_이코테._02구현;

import java.util.Scanner;

public class 시각 {

    /* 00시 00분 00초부터 N시 59분 59초까지 모든 시각중에
    * 3이 하나라도 포함되는 모든 경우의 수를 출력합니다.
    * 0<=N<=23*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 15*60 + 45*15; //(3포함분)x60개 && (!3포함분)x15개
        int total;

        if (n<3)
            total = (n+1)*cnt;

        else if (n<13)
            total = n*cnt + 60*60;
        else
            total = (n-1)*cnt + 2*60*60;

        System.out.println(total);
        //5 => 11475

    }
}

//완전탐색 방법 (3이 포함되어 있는지 전부 확인)
class Main {

    // 특정한 시각 안에 '3'이 포함되어 있는지의 여부
    public static boolean check(int h, int m, int s) {
        if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3)
            return true;
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // H를 입력받기
        int h = sc.nextInt();
        int cnt = 0;

        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    if (check(i, j, k)) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

}
