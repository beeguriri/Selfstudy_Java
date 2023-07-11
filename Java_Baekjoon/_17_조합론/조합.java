package Java_Baekjoon._17_조합론;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class 조합 {

    //n과 m이 주어진다. (5 ≤ n ≤ 100, 5 ≤ m ≤ 100, m ≤ n)
    static BigInteger [][] dp = new BigInteger [101][101];

    static BigInteger combination(int n, int r) {
        if(!dp[n][r].equals(BigInteger.ZERO))
            return dp[n][r];
        if(n==r || r==0)
            return dp[n][r] = BigInteger.ONE;

        return dp[n][r] = combination(n-1, r-1).add(combination(n-1, r));

    }

    public static void main(String[] args) {

        //100 50에 대해서
        //
        //100891344545564193334812497256
        for(int i=0; i<=100; i++)
            Arrays.fill(dp[i], BigInteger.ZERO);

        Scanner sc = new Scanner(System.in);
        System.out.println(combination(sc.nextInt(), sc.nextInt()));
    }
}
