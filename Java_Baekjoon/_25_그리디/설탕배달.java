package Java_Baekjoon._25_그리디;

import java.util.Scanner;

public class 설탕배달 {

    /* 설탕공장에서 만드는 설탕은 봉지에 담겨져 있다.
    봉지는 3킬로그램 봉지와 5킬로그램 봉지가 있다.
    상근이가 설탕을 정확하게 N킬로그램 배달해야 할 때,
    최소 봉지 몇 개를 가져가면 되는지 그 수를 구하는 프로그램을 작성하시오.
    첫째 줄에 N이 주어진다. (3 ≤ N ≤ 5000)
    상근이가 배달하는 봉지의 최소 개수를 출력한다.
    만약, 정확하게 N킬로그램을 만들 수 없다면 -1을 출력한다.*/

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;

        while(n>0) {
            if(n%5==0) {
                answer += n/5;
                break;
            }
            else if(n>=3){
                n -= 3;
                answer++;
            } else {
                answer = -1;
                break;
            }
        }

        System.out.println(answer);
        //18 4
        //4 -1
        //6 2
        //9 3
        //11 3


    }
}
