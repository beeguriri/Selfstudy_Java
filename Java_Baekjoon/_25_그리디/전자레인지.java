package Java_Baekjoon._25_그리디;

import java.util.Scanner;

public class 전자레인지 {

    /*버튼 A, B, C에 지정된 시간은 각각 5분, 1분, 10초이다.
    * 첫 번째 줄에는 요리시간 T(초)가 정수로 주어져 있으며 그 범위는 1 ≤ T ≤ 10,000 이다.
    여러분은 T초를 위한 최소버튼 조작의 A B C 횟수를 첫 줄에 차례대로 출력해야 한다.
    * 각각의 횟수 사이에는 빈 칸을 둔다.
    * 해당 버튼을 누르지 않는 경우에는 숫자 0을 출력해야한다.
    * 만일 제시된 3개의 버튼으로 T초를 맞출 수 없으면 음수 -1을 첫 줄에 출력해야 한다.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int cntA = 0;
        int cntB = 0;
        int cntC = 0;

        if(t % 10 != 0) {
            System.out.println(-1);
            return;
        }

        while(t>0) {
            cntA += t/300;
            t %= 300;
            cntB += t/60;
            t %= 60;
            cntC += t/10;
            t %= 10;
        }
        System.out.println(cntA + " " + cntB + " " + cntC);

        //100 => 0 1 4
        //189 => -1
    }
}
