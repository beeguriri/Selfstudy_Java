package Java_Baekjoon._33_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = start+1;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        if(arr[start]>=s) {
            sum = arr[start];
            min = 1;
        }
        else {
            sum = arr[start] + arr[end];
        }

        while(start<=end && end<=n-1){

            if(sum>=s){
                min = Math.min(min, end - start + 1);
                sum -= arr[start];
                start++;
            } else {
                if(end<=n-2) {
                    end++;
                    sum += arr[end];
                } else
                    end++;
            }
        }

        if (min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);

    }
}
