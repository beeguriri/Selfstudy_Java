package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 센서 {

    /*첫째 줄에 센서의 개수 N(1 ≤ N ≤ 10,000),
    둘째 줄에 집중국의 개수 K(1 ≤ K ≤ 1000)가 주어진다.
    셋째 줄에는 N개의 센서의 좌표가 한 개의 정수로 N개 주어진다.
    각 좌표 사이에는 빈 칸이 하나 있으며, 좌표의 절댓값은 1,000,000 이하이다.
    첫째 줄에 문제에서 설명한 최대 K개의 집중국의 수신 가능 영역의 길이의 합의 최솟값을 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        Integer [] sensor = new Integer [n];
        Integer [] diff = new Integer [n-1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            sensor[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(sensor);

        for(int i=0; i<n-1; i++)
            diff[i] = sensor[i+1] - sensor[i];

        Arrays.sort(diff, Collections.reverseOrder());

        System.out.println(Arrays.toString(sensor));
        System.out.println(Arrays.toString(diff));

        int sum = 0;
        for(int i = k-1; i<n-1; i++)
            sum += diff[i];

        System.out.println(sum);

    }
}
