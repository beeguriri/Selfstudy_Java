package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 네트워크복구 {

    static class Node implements Comparable<Node>{
        private int index;
        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        public int compareTo(Node o) {
            return this.distance - o.distance;
        }
    }

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;
    public static int [] visited;

    public static void dijkstra(int start) {

        Queue<Node> pq = new PriorityQueue<Node>();
        d[start] = 0;
        visited[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now] < dist)
                continue;

            for(int i=0; i<graph.get(now).size(); i++) {

                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[idx]) {
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                    visited[idx] = now;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        d = new int [n+1];
        visited = new int [n+1];

        Arrays.fill(d, INF);
        Arrays.fill(visited, -1);

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
            visited[b] = a;
            visited[a] = b;
        }

        dijkstra(1);
//        System.out.println(Arrays.toString(d));
//        System.out.println(Arrays.toString(visited));

        StringBuilder sb = new StringBuilder();
        int count = 0;
        for(int i=1; i<=n; i++) {

            if(d[i]!=INF)
                count += 1;

            if(visited[i]>0) {
                sb.append(i).append(" ").append(visited[i]).append("\n");
            }

        }

        System.out.println(count-1);
        System.out.println(sb);

    }

}
