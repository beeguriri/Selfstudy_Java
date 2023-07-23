package Java_Programmers.Level2;

import java.util.*;

public class 배달 {

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
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    //N개의 도시에 K시간 이하로 배달
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        // 그래프 초기화
        for(int i=0; i<=N; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<road.length; i++) {
            int a = road[i][0];
            int b = road[i][1];
            int dist = road[i][2];

            graph.get(a).add(new Node(b, dist));
            graph.get(b).add(new Node(a, dist));
        }

        //거리 확인용 배열 초기화
        d = new int [N+1];
        Arrays.fill(d, INF);

        djikstra(1, K);

//        System.out.println(Arrays.toString(d));
        for(int i : d) {
            if(i!=INF)
                answer++;
        }
        return answer;
    }

    public static void djikstra(int start, int K) {

        Queue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.distance - o2.distance));
        d[start] = 0;

        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();
            int distance = node.getDistance();

            if(d[now] < distance)
                continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[idx] && cost <=K) {
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(5, new int [][] {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}}, 3));
    }
}

