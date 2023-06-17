package Java_Baekjoon._23_동적계획법.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 가장긴감소하는부분수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] arr = new int [n];
        int [] dp = new int [n];
        List<Set<Integer>> temp = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            temp.add(new HashSet<>());
        }

        for(int i=0; i<n; i++){
            dp[i] = 1;
            temp.get(i).add(arr[i]);
            for(int j=0; j<i; j++) {
                if (arr[j] > arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    temp.get(i).add(arr[j]);
                }
            }
        }

        int max = 0;
        for(int i: dp)
            max = Math.max(max, i);

        System.out.println(Arrays.toString(dp));
        System.out.println(max);

        for (Set<Integer> set : temp) {
            System.out.println(set.stream().toList());
        }
    }
}
