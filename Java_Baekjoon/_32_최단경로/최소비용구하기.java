package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기 {

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

    public static final int INF = (int)1e9;
    public static int n, m;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    public static void dijkstra(int start) {

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now]<dist)
                continue;

            for (int i=0; i<graph.get(now).size() ; i++) {

                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[idx]) {
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        d = new int [n+1];
        Arrays.fill(d, INF);

        dijkstra(start);

        System.out.println(d[end]);
    }

}
