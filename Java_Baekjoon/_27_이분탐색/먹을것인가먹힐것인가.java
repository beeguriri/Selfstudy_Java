package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을것인가먹힐것인가 {


    /*첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스의 첫째 줄에는 A의 수 N과 B의 수 M이 주어진다.
    둘째 줄에는 A의 크기가 모두 주어지며, 셋째 줄에는 B의 크기가 모두 주어진다.
    크기는 양의 정수이다. (1 ≤ N, M ≤ 20,000)
    각 테스트 케이스마다, A가 B보다 큰 쌍의 개수를 출력한다. */

    public static int binaryUpper(int [] arrB, int target, int start, int end){

        int cnt = 0;
        while(start <= end) {

            int mid = (start + end) / 2;

            if(target>arrB[mid]) {
                start = mid + 1;
                cnt = mid + 1;
            }
            else {
                end = mid -1;
            }
        }

        return cnt;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int [] arrA = new int [n];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                arrA[j] = Integer.parseInt(st.nextToken());

            int [] arrB = new int [m];
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++)
                arrB[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(arrA);
            Arrays.sort(arrB);

            int result = 0;
            for(int j=0; j<n; j++)
                result += binaryUpper(arrB, arrA[j], 0, m-1);

            System.out.println(result);

        }

    }
}
