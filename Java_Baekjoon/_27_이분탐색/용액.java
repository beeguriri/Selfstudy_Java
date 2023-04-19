package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 용액 {

    public static void binarySearch(int [] arr, int start, int end) {

        int max = Integer.MAX_VALUE;
        int x=0;
        int y=0;

        while(start<end){

            int sum = arr[start] + arr[end];

            if(Math.abs(sum)<Math.abs(max)){
                max = sum;
                x = arr[start];
                y = arr[end];
            }

            if(sum<0)
                start++;

            else
                end--;

        }

        System.out.println(x + " " + y);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

//        int result = Integer.MAX_VALUE;
//        int x = 0;
//        int y = 0;
//        for(int i=0; i<n-1; i++){
//            for(int j=i+1; j<n; j++){
//                if(Math.abs(arr[i] + arr[j])<Math.abs(result)){
//                    result = arr[i] + arr[j];
//                    x = arr[i];
//                    y = arr[j];
//                }
//            }
//        }

        binarySearch(arr, 0, n-1);

    }
}
