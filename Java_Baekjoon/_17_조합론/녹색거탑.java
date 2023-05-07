package Java_Baekjoon._17_조합론;

import java.util.Scanner;

public class 녹색거탑 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        long answer = 1;
        for(int i=1; i<=n; i++)
            answer *= 2;

        System.out.println(answer);


    }
}
