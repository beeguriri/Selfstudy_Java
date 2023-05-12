package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 포도주시식 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n+1];
        int [] dp = new int [n+1];

        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        dp[1] = arr[1];
        if(n>=2)
            dp[2] = arr[1] + arr[2];
        for(int i=3; i<=n; i++)
            //무조건 맨 마지막 잔을 마셔야된다는 말이 없으니까...
            dp[i] = Math.max(dp[i-1],
                        Math.max(dp[i-3] + arr[i-1], dp[i-2])+arr[i]);

        int max = 0;
        for(int i=1; i<=n; i++)
            max = Math.max(max, dp[i]);

        System.out.println(max);
    }
}
