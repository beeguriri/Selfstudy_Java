package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정한최단경로 {

    public static class Node {
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
    }

    public static final int INF = 200000*1000;
    public static int n, e;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    public static int dijkstra(int start, int end) {

        d = new int [n+1];
        Arrays.fill(d, INF);

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now] < dist)
                continue;

            for(int i=0; i<graph.get(now).size(); i++){
                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost<d[idx]){
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }

        return d[end];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int ans1 = 0;
        ans1 += dijkstra(1, v1);
        ans1 += dijkstra(v1, v2);
        ans1 += dijkstra(v2, n);

        int ans2 = 0;
        ans2 += dijkstra(1, v2);
        ans2 += dijkstra(v2, v1);
        ans2 += dijkstra(v1, n);

        if(ans1 >= INF && ans2 >= INF)
            System.out.println(-1);
        else
            System.out.println(Math.min(ans1, ans2));
    }
}
