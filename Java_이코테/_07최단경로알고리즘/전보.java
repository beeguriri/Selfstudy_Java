package Java_이코테._07최단경로알고리즘;

import java.util.*;

public class 전보 {

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

    public static final int INF = (int) 1e9;
    public static int n, m, c;

    public static int [] d;
    public static List<ArrayList<Node>> graph = new ArrayList<>();

    public static void dijkstra(int start) {

        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.distance - o2.distance;
            }
        });

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {

            // 최단거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            // 현재 노드가 이미 방문한 노드면 무시
            if(d[now] < dist)
                continue;

            // 현재 노드와 연결 된 인접노드 확인
            for(int i=0; i<graph.get(now).size(); i++){
                int idx = graph.get(now).get(i).getIndex();
                int cost = graph.get(now).get(i).getDistance();

                if(cost < d[idx]){
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        n=3; m=2; c=1;
        d = new int [n+1];

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        graph.get(1).add(new Node(2, 4));
        graph.get(1).add(new Node(3, 2));

        Arrays.fill(d, INF);

        dijkstra(c);

        System.out.println(Arrays.toString(d));

        int city = 0;
        int maxValue = 0;
        for(int i=1; i<=n; i++){
            if(d[i]!=INF){
                city += 1;
                maxValue = Math.max(maxValue, d[i]);
            }
        }

        System.out.println((city-1) + " " + maxValue);

    }
}
