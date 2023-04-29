package Java_Baekjoon._33_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두수의합 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int x = Integer.parseInt(br.readLine());
        int cnt = 0;

        int start = 0;
        int end = n-1;

        while(start<end){

            int sum = arr[start] + arr[end];
            if(sum==x){
                cnt++;
                end--;
            } else if(sum>x)
                end--;
            else
                start++;
        }

        System.out.println(cnt);
    }
}
