package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        int [] dp = new int [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        for(int i=0; i<n; i++){

            //무조건 1 이상의 길이를 가짐
            dp[i] = 1;

            for(int j=0; j<i; j++)
                if(arr[j]<arr[i])
                    dp[i] = Math.max(dp[i], dp[j]+1);

        }

        int max = 0;
        for(int i : dp)
            max = Math.max(max, i);

        System.out.println(max);

    }
}
