package Java_Baekjoon._23_동적계획법;

import java.util.Scanner;

public class 알고리즘수업_피보나치수1 {

    public static int fibCnt=1;
    public static int fibonacciCnt=0;
    public static int f[];

    public static long fib(int n) {

        if (n==1 || n==2)
            return 1;
        else {
            fibCnt = fibCnt +1;
            return (fib(n - 1) + fib(n - 2));
        }
    }


    public static long fibonacci(int n) {

        f[1] = 1;
        f[2] = 1;

        for(int i=3; i<=n; i++) {
            fibonacciCnt = fibonacciCnt + 1;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        f = new int [n+1];

        long fib_result = fib(n);
        long fibo_result = fibonacci(n);

        System.out.println(fibCnt + " " + fibonacciCnt);


    }
}
