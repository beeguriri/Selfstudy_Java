package Java_Baekjoon._33_투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 수열 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] temp = new int [n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            temp[i] = Integer.parseInt(st.nextToken());

        // 초기값 설정
        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += temp[i];

        int max = sum;

        for (int i = 1; i <= n-k; i++){
            sum -= temp[i-1];
            sum += temp[i+k-1];
            max = Math.max(max, sum);
        }

        System.out.println(max);

    }
}
