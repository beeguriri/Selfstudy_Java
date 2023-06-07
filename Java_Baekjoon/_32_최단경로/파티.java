package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 파티 {

    public static final int INF = (int) 1e9;
    public static int n, m, x;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    static class Node implements Comparable<Node>{

        private int index;
        private int time;

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
            return this.getTime() < o.getTime() ? -1 : 1;
        }
    }

    public static int dijkstra(int start, int end) {

        Queue<Node> pq = new PriorityQueue<>();
        Arrays.fill(d, INF);
        d[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();
            int time = node.getTime();

            if(d[now]<time)
                continue;

            for(int i=0; i<graph.get(now).size(); i++){

                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getTime();

                if(cost < d[idx]) {
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

        n = Integer.parseInt(st.nextToken()); // 마을
        m = Integer.parseInt(st.nextToken()); // 도로 개수
        x = Integer.parseInt(st.nextToken()); // x번 마을

        d = new int[n+1];
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
        }

        int result = 0;
        for(int i=1; i<=n; i++)
            result = Math.max(result, dijkstra(i, x) + dijkstra(x, i));

        System.out.println(result);
    }
}
