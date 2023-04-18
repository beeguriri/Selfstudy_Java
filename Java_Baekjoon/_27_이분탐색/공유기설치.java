package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 공유기설치 {

    /*첫째 줄에 집의 개수 N (2 ≤ N ≤ 200,000)과 공유기의 개수 C (2 ≤ C ≤ N)이
    하나 이상의 빈 칸을 사이에 두고 주어진다.
    둘째 줄부터 N개의 줄에는 집의 좌표를 나타내는 xi (0 ≤ xi ≤ 1,000,000,000)가
    한 줄에 하나씩 주어진다.
    첫째 줄에 가장 인접한 두 공유기 사이의 최대 거리를 출력한다. */

    public static int binarySearch(int [] arr, int target, int start, int end){

        while(start <= end) {

            int mid = (start + end) / 2;
            int first = arr[0];
            int cnt = 1;
            int dist = 0;

            for (int i: arr) {
                dist = i - first;
                if(dist >= mid) {
                    cnt++;
                    first = i;
                }
            }

            if (target<=cnt) {
                //dist 늘리기
                start = mid+1;
            } else {
                //dist 를 줄여야함
                end = mid-1;
            }
        }

        return start-1;
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int n = Integer.parseInt(s.split(" ")[0]);
        int c = Integer.parseInt(s.split(" ")[1]);

        int [] arr = new int [n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        System.out.println(binarySearch(arr, c, 1, arr[n-1]-arr[0]));
    }
}
