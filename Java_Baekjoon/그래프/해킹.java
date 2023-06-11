package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 해킹 {

    static class Node implements Comparable<Node> {

        private final int index;
        private final int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }

        public int getIndex() {
            return index;
        }

        public int getTime() {
            return time;
        }

        public int compareTo(Node o){
            return this.time - o.time;
        }
    }

    public static final int INF = (int) 1e9;
    public static int n, d, c;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] times;

    public static void dijkstra(int start) {

        Queue<Node> pq = new PriorityQueue<>();
        times[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int nowI = node.getIndex();
            int nowT = node.getTime();

            if(times[nowI] < nowT)
                continue;

            for(int i=0; i<graph.get(nowI).size(); i++) {

                int idx = graph.get(nowI).get(i).getIndex();
                int cost = times[nowI] + graph.get(nowI).get(i).getTime();

                if(cost<times[idx]) {
                    times[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int CASE = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<CASE; i++){

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            for(int j=0; j<=n; j++)
                graph.add(new ArrayList<>());

            times = new int [n+1];
            Arrays.fill(times, INF);

            for(int j=0; j<d; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                //컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염됨을 뜻한다.
                graph.get(b).add(new Node(a, t));
            }

            dijkstra(c);
            graph.clear();

            int count = 0;
            int result = 0;

            for(int x : times) {
                if(x!=INF){
                    count += 1;
                    result = Math.max(result, x);
                }
            }
            sb.append(count).append(" ").append(result).append("\n");
        }

        System.out.print(sb);

    }
}
