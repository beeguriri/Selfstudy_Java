package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 기타레슨 {

    /*첫째 줄에 강의의 수 N (1 ≤ N ≤ 100,000)과 M (1 ≤ M ≤ N)이 주어진다.
    다음 줄에는 강토의 기타 강의의 길이가 강의 순서대로 분 단위로(자연수)로 주어진다.
    각 강의의 길이는 10,000분을 넘지 않는다.
    첫째 줄에 가능한 블루레이 크기중 최소를 출력한다. */

    public static int binarySearch(int[] arr, int target, int start, int end) {

        while(start<end) {

            int mid = (start + end) / 2;
            int sum = 0;
            int cnt = 0;

            for(int i: arr){
                if(i + sum > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += i;
            }

            if(sum !=0) cnt++;

            if(cnt<=target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];
        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            start = Math.max(start,arr[i]);
            end += arr[i];
        }

        System.out.println(binarySearch(arr, m, start, end));

    }
}
