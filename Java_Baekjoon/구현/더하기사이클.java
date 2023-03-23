package Java_Baekjoon.구현;

import java.util.Scanner;

public class 더하기사이클 {

    /*0보다 크거나 같고, 99보다 작거나 같은 정수가 주어질 때
    * 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고, 각 자리의 숫자를 더한다.
    * 그 다음, 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 새로운 수를 만들 수 있다.
    * 26부터 시작한다.
    * 2+6 = 8 => 68 => 6+8 = 14 => 8+4 = 12 => 42 => 4+2 = 6 => 26이다.
    * 위의 예는 4번만에 원래 수로 돌아올 수 있다. 따라서 26의 사이클의 길이는 4이다.
    * N이 주어졌을 때, N의 사이클의 길이를 구하는 프로그램을 작성하시오.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int temp = num;
        int cnt = 0;

        while(true) {

            int left = temp/10; //2
            int right = temp%10; //6
            temp = right*10 + (left+right)%10;
            cnt++;

            if(temp==num)
                break;
        }

        System.out.println(cnt);

        //26 => 4
        //55 =>3
        //1 => 60
        //0 => 1
        //71 => 12

    }

}
