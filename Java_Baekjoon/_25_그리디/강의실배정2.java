package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 강의실배정2 {

    public static int n;
    public static int [][] targets;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        targets = new int [n][2];
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            targets[i][0] = Integer.parseInt(st.nextToken());
            targets[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(targets, (o1, o2) -> o1[0]==o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);

        //종료시간을 넣어줌
        Queue<Integer> pq = new PriorityQueue<>();

        for(int [] target : targets) {

            if(pq.isEmpty()) {
                pq.offer(target[1]);
                continue;
            }

            if(target[0]>=pq.peek()){
                pq.poll();
                pq.offer(target[1]);
            } else {
                pq.offer(target[1]);
            }
        }

        System.out.println(pq.size());
    }
}
