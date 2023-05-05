package Java_Baekjoon._17_조합론;

import java.util.Scanner;

public class 팩토리얼 {


    public static long factorial(int x) {

        if(x==0)
            return 1;

        return x * factorial(x-1);

    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(factorial(n));
    }
}
