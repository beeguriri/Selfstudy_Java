package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class 전깃줄 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int [][] arr = new int [n][2];
        int [] dp = new int [n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(arr));

        for(int i=0; i<n; i++){
            dp[i] = 1;

            for(int j=0; j<i; j++) {
                if(arr[j][1] < arr[i][1])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        System.out.println(Arrays.toString(dp));
        int max = 0;
        for(int i : dp)
            max = Math.max(max, i);

        System.out.println(n-max);
    }
}
