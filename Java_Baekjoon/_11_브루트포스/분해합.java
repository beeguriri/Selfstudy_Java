package Java_Baekjoon._11_브루트포스;

import java.util.Scanner;

public class 분해합 {

    /*어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
    어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
    예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다.
    따라서 245는 256의 생성자가 된다.
    물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다.
    반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
    첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
    첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        for(int i =1; i<=n; i++) {

            int num = i;    //245
            int sumN = i;

            while(num>0) {
                sumN += num % 10;   //245%10 = 5; ->24 % 10 => 4 2%10 => 2
                num /= 10; //245/10 = 24; 24/10 => 2 2/10 = 0;
            }

            if(sumN == n) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
