package Java_Baekjoon._23_동적계획법.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class 연속합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];
        int [] dp = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        dp[0] = arr[0];
        for(int i=1; i<n; i++)
            dp[i] = Math.max(arr[i], dp[i-1] + arr[i]);

//        System.out.println(Arrays.toString(dp));

        int max = Integer.MIN_VALUE;
        for(int i : dp)
            max = Math.max(max, i);


        System.out.println(max);

    }
}
