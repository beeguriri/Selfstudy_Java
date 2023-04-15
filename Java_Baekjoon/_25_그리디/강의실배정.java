package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 강의실배정 {

    /*첫 번째 줄에 N이 주어진다. (1 ≤ N ≤ 200,000)
    이후 N개의 줄에 Si, Ti가 주어진다. (0 ≤ Si < Ti ≤ 109)
    Ti ≤ Sj 일 경우 i 수업과 j 수업은 같이 들을 수 있다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        //우선큐 : 기본이 오름차순 (min heap)
        PriorityQueue<Integer> q = new PriorityQueue<>();

        StringTokenizer st;
        int [][] times = new int[n][2];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            times[i][0] = Integer.parseInt(st.nextToken());
            times[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(times, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //시작시간 기준 오름차순, 같으면 종료시간 기준 오름차순
                return o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });

        q.offer(times[0][1]);

        for(int i=1; i<n; i++) {

            int prev = q.peek();

            if(times[i][0]<prev)
                q.offer(times[i][1]);
            else {
                q.poll();
                q.offer(times[i][1]);
            }
        }

        System.out.println(q.size());
    }
}
