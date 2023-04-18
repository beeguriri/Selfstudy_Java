package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 암기왕Ver2 {

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
            for(int i:arr2){
                if(Arrays.binarySearch(arr1, i)>=0)
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
//                System.out.println(Arrays.binarySearch(arr1, i));
            }

            System.out.print(sb);

        }
    }
}
