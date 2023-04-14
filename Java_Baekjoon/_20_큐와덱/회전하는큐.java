package Java_Baekjoon._20_큐와덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 회전하는큐 {

    /*첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다.
    * 둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다.
    * 첫째 줄에 문제의 정답을 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [] arr = new int [m];

        for(int i=1; i<=n; i++)
            q.offer(i);

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<m; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;

        for(int i : arr) {

            if(q.peekFirst() == i) {
                q.poll();
                continue;
            }

            while(q.peekFirst() != i) {

                int idx = q.indexOf(i);
                int mid = q.size()/2;

                if(idx<=mid)
                    q.offerLast(q.pollFirst());
                else
                    q.offerFirst(q.pollLast());

                cnt++;

                if(q.peekFirst()==i) {
                    q.poll();
                    break;
                }
            }
        }
        System.out.println(cnt);

    }
}
