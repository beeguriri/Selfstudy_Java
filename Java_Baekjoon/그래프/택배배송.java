package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 택배배송 {

    static class Node implements Comparable<Node>{

        private int index;
        private int count;

        public Node(int index, int count) {
            this.index = index;
            this.count = count;
        }

        public int getIndex() {
            return index;
        }

        public int getCount() {
            return count;
        }

        public int compareTo(Node o){
            return this.count - o.count;
        }
    }

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    public static void dijkstra(int start) {

        d[start] = 0;

        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getCount();

            if(d[now] < dist)
                continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getCount();

                if(cost < d[idx]) {
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        d = new int [n+1];
        Arrays.fill(d, INF);

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        dijkstra(1);

        System.out.println(d[n]);
    }
}
