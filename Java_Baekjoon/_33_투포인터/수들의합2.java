package Java_Baekjoon._33_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수들의합2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int sum = 0;
        int cnt = 0;

        while(start<n){

            if(sum > m || end == n)
                sum -= arr[start++];
            else
                sum += arr[end++];

            if(sum==m)
                cnt+=1;
        }

        System.out.println(cnt);

    }
}