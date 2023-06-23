package Java_Baekjoon._23_동적계획법;

import java.util.Scanner;

public class _2n타일링2 {

    //2*1 = 1개
    //2*2 = 3개
    //2*3 = 5개
    //2*4 = 11개???

    public static int [] dp = new int [1001];

    public static int findDp(int x) {

        for(int i=3; i<=x; i++)
            dp[i] = (dp[i-1] + dp[i-2]*2) % 10007;

        return dp[x];
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        dp[1] = 1;
        dp[2] = 3;

        System.out.println(findDp(sc.nextInt()));
    }
}

