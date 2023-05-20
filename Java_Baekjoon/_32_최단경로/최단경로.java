package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최단경로 {

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

    public static int INF = (int) 1e9;
    public static int V, E, K;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    public static void dijkstra(int start) {

        Queue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance-o2.distance);

        d[start] = 0;
        pq.offer(new Node(start, 0));

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
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); //정점의 개수
        E = Integer.parseInt(st.nextToken()); //간선의 개수
        K = Integer.parseInt(br.readLine()); //시작점

        // 그래프 초기화
        for(int i=0; i<=V; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        d = new int [V+1];
        Arrays.fill(d, INF);

        dijkstra(K);

//        System.out.println(Arrays.toString(d));
        for(int i=1; i<=V; i++){
            if(d[i]>=INF)
                System.out.println("INF");
            else
                System.out.println(d[i]);
        }

    }
}
