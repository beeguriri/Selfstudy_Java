package Java_Baekjoon._17_조합론;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class 이항계수2 {

    public static BigInteger[][] dp = new BigInteger [1001][1001];

    public static BigInteger comb(int n, int r) {

        if(!dp[n][r].equals(BigInteger.ZERO))
            return dp[n][r].mod(BigInteger.valueOf(10007));

        if(n==r || r==0)
            return BigInteger.ONE;

        return dp[n][r] = comb(n-1, r-1).add(comb(n-1, r)).mod(BigInteger.valueOf(10007));
    }

    public static void main(String[] args) {

        for(int i=0; i<=1000; i++)
            Arrays.fill(dp[i], BigInteger.ZERO);
        //10,007
        Scanner sc = new Scanner(System.in);
        System.out.println(comb(sc.nextInt(), sc.nextInt()));

    }
}
