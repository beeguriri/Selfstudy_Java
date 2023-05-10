package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 정수삼각형 {

    public static List<List<Integer>> list = new ArrayList<>();
    public static int [][] dp;
    public static int n;

    public static int sumTriangle(){

        if(n==1)
            return list.get(0).get(0);

        dp[0][0] = list.get(0).get(0);

        for(int i=1; i<n; i++) {
            for(int j=0; j<list.get(i).size(); j++) {
                if(j==0)
                    dp[i][j] = dp[i-1][0] + list.get(i).get(j);
                else if (j==list.get(i).size()-1)
                    dp[i][j] = dp[i-1][list.get(i).size()-2] + list.get(i).get(j);
                else
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + list.get(i).get(j);
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for(int i=0; i<n; i++)
            maxVal = Math.max(maxVal, dp[n-1][i]);

        return maxVal;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int [n][n];

        for(int i=0; i<n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new ArrayList<>());

            int x = st.countTokens();

            for(int j=0; j<x; j++)
                list.get(i).add(Integer.parseInt(st.nextToken()));

        }

        System.out.println(sumTriangle());
//        System.out.println(Arrays.deepToString(dp));
    }
}
