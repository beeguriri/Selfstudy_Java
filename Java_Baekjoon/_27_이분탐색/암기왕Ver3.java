package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암기왕Ver3 {

    public static int binarySearch(int [] arr, int target, int start, int end){

        while(start<=end){

            int mid = (start + end) / 2;
            if(arr[mid] == target)
                return 1;
            else if (arr[mid]<target)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine());

        for(int t=0; t<tCase; t++){

            int n = Integer.parseInt(br.readLine());
            int [] arr1 = new int [n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<n; i++)
                arr1[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(arr1);

            int m = Integer.parseInt(br.readLine());
            int [] arr2 = new int [m];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<m; i++)
                arr2[i] = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            for(int i:arr2)
                sb.append(binarySearch(arr1, i, 0, arr1.length-1)).append("\n");

            System.out.print(sb);

        }
    }
}
