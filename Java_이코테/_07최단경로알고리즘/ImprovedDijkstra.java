package Java_이코테._07최단경로알고리즘;

import java.util.*;

public class ImprovedDijkstra {
//implements Comparable<Node>
    private static class Node {

        private final int index;
        private final int distance;

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
//
//        @Override
//        public int compareTo(Node other) {
//            return this.distance < other.distance ? -1 : 1;
//        }
    }

    public static final int INF = (int) 1e9;
    public static int n, m, start;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    public static void dijkstra(int start) {

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.distance - o2.distance;
            }
        });

        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()){

            //최단거리가 가장 짧은 노드 꺼내기
            Node node = pq.poll();

            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now]<dist)
                continue;

            for (int i=0; i<graph.get(now).size(); i++){
                
                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                //최단경로가 더 작을때만 큐에 넣어줌
                if(cost < d[idx]){
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }
    }

    public static void main(String[] args) {

        n = 6;
        m = 11;
        start = 1;

        // 배열 초기화
        d = new int [n+1];

        // 그래프 초기화
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        // 그래프 입력
        graph.get(1).add(new Node(2, 2)); graph.get(1).add(new Node(3, 5)); graph.get(1).add(new Node(4, 1));
        graph.get(2).add(new Node(3, 3)); graph.get(2).add(new Node(4, 2));
        graph.get(3).add(new Node(2, 3)); graph.get(3).add(new Node(6, 5));
        graph.get(4).add(new Node(3, 3)); graph.get(4).add(new Node(5, 1));
        graph.get(5).add(new Node(3, 1)); graph.get(5).add(new Node(6, 2));

        // 거리배열 채우기
        Arrays.fill(d, INF);

        dijkstra(start);

        // 최단거리 출력
        for(int i=1; i<=n; i++){
            if(d[i]==INF)
                System.out.println("Infinity");
            else
                System.out.print(d[i] + " ");
        }
    }
}
