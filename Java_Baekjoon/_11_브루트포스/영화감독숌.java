package Java_Baekjoon._11_브루트포스;

import java.util.Scanner;

public class 영화감독숌 {

    /*첫째 줄에 N이 주어진다. N은 10,000보다 작거나 같은 자연수이다.
    종말의 수란 어떤 수에 6이 적어도 3개 이상 연속으로 들어가는 수를 말한다.
    제일 작은 종말의 수는 666이고, 그 다음으로 큰 수는 1666, 2666, 3666, .... 이다.
    첫째 줄에 N번째 영화의 제목에 들어간 수를 출력한다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int num = 666;
        int cnt = 1;

        while(cnt<n) {
            num++;
            if (String.valueOf(num).contains("666"))
                cnt++;
        }

        System.out.println(num);

    }
}
