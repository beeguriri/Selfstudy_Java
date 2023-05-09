package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int [] dp = new int [n];

        dp[0] = arr[0];

        int maxVal = arr[0];

        for(int i=1; i<n; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            maxVal = Math.max(maxVal, dp[i]);
        }


        System.out.println(maxVal);


    }
}
