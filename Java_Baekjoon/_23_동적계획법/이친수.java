package Java_Baekjoon._23_동적계획법;

import java.util.Scanner;

public class 이친수 {

    //1 -> 1 (1)
    //2 -> 1 (10)
    //3 -> 2(101, 100)
    //4 -> 3(1001, 1010, 1000) ..


    public static long [] dp = new long [91];
    public static long findCount(int x) {

        dp[1]= 1;
        dp[2]= 1;

        for(int i=3; i<=x; i++)
            dp[i] = dp[i-1] + dp[i-2];

        return dp[x];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(findCount(n));

    }
}
