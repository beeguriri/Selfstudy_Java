package Java_Baekjoon._06_심화1;

import java.util.Scanner;

public class 별찍기7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt() * 2 - 1; //9

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i+=2)
            sb.append(" ".repeat((n-i)/2)).append("*".repeat(i)).append("\n");

        for(int i = n-2; i>=1; i-=2)
            sb.append(" ".repeat((n-i)/2)).append("*".repeat(i)).append("\n");

        System.out.println(sb);

    }
}
