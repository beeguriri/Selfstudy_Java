package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 예산 {

    /*모든 요청이 배정될 수 있는 경우에는 요청한 금액을 그대로 배정한다.
    모든 요청이 배정될 수 없는 경우에는
    특정한 정수 상한액을 계산하여 그 이상인 예산요청에는 모두 상한액을 배정한다.
    상한액 이하의 예산요청에 대해서는 요청한 금액을 그대로 배정한다.
    첫째 줄에는 지방의 수를 의미하는 정수 N이 주어진다. N은 3 이상 10,000 이하이다.
    다음 줄에는 각 지방의 예산요청을 표현하는 N개의 정수가 빈칸을 사이에 두고 주어진다.
    이 값들은 모두 1 이상 100,000 이하이다.
    그 다음 줄에는 총 예산을 나타내는 정수 M이 주어진다.
    M은 N 이상 1,000,000,000 이하이다.
    첫째 줄에는 배정된 예산들 중 최댓값인 정수를 출력한다. */

    public static int binarySearch(int [] arr, int target, long start, long end){

        long result = 0;

        while(start <= end) {

            long sum = 0;
            long mid = (start + end) /2;

            for(long i: arr) {
                if (i<mid)
                    sum += i;
                else
                    sum += mid;
            }

            if(sum > target)
                end = mid - 1;

            else {
                start = mid + 1;
                result = Math.max(result, mid);
            }
        }
        return (int) result;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] budget = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        for(int i=0; i<n; i++) {
            budget[i] = Integer.parseInt(st.nextToken());
            sum += budget[i];
        }

        int m = Integer.parseInt(br.readLine());

        Arrays.sort(budget);

        if(sum<=m)
            System.out.println(budget[n-1]);
        else
            System.out.println(binarySearch(budget, m, 0, budget[n-1]));
    }
}
