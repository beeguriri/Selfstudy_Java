package Java_Baekjoon._20_큐와덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 풍선터뜨리기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int []> q = new ArrayDeque<>();
//        Deque<int []> te = new ArrayDeque<>();

        for(int i=1; i<=n; i++)
            //{종이에 적힌 수, index}
            q.offer(new int [] {Integer.parseInt(st.nextToken()), i});

        StringBuilder sb = new StringBuilder();

        int [] temp = q.poll();
        int dir = temp[0];
        sb.append(temp[1]).append(" ");

        while(!q.isEmpty()) {

            if(dir>0) {
                for(int i=0; i<dir-1; i++)
                    q.offerLast(q.pollFirst());
                temp = q.pollFirst();

            } else {
                for(int i=0; i<Math.abs(dir)-1; i++)
                    q.offerFirst(q.pollLast());
                temp = q.pollLast();
            }

            dir = temp[0];
            sb.append(temp[1]).append(" ");

        }

        System.out.println(sb);

    }
}
