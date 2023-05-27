package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미확인도착지 {

    public static class Node {
        private int city;
        private int distance;

        public Node(int city, int distance) {
            this.city = city;
            this.distance = distance;
        }

        public int getCity() {
            return city;
        }

        public int getDistance() {
            return distance;
        }

    }

    public static final int INF = (int) 1e9;
    public static int [] dist;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int T, n, m, t, s, g, h;

    public static int dijkstra (int start, int end){

        Queue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.distance - o2.distance;
            }
        });

        // 거리 테이블 초기화
        dist = new int [n+1];
        Arrays.fill(dist, INF);

        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getCity();
            int distance = node.getDistance();

            if(dist[now]<distance)
                continue;

            for(int i=0; i<graph.get(now).size(); i++) {
                int idx = graph.get(now).get(i).getCity();
                int cost = dist[now] + graph.get(now).get(i).getDistance();

                if(cost < dist[idx]){
                    dist[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }
            }
        }
        return dist[end];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++){

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //교차로
            m = Integer.parseInt(st.nextToken()); //도로
            t = Integer.parseInt(st.nextToken()); //목적지 후보 개수

            // 간선 정보 초기화
            for(int j=0; j<=n; j++)
                graph.add(new ArrayList<>());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken()); //출발지
            g = Integer.parseInt(st.nextToken()); //경유1
            h = Integer.parseInt(st.nextToken()); //경유2

            for(int j=0; j<m; j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph.get(a).add(new Node(b, c));
                graph.get(b).add(new Node(a, c));
            }

            // 목적지 별 최단경로 찾기
            List<Integer> result = new ArrayList<>();
            for(int j=0; j<t; j++) {

                int finalDest = Integer.parseInt(br.readLine());

                int ans1 = Math.min(dijkstra(s, g) + dijkstra(g, h) + dijkstra(h, finalDest),
                                        dijkstra(s, h)+ dijkstra(h, g) + dijkstra(g, finalDest));
                int ans2 = dijkstra(s, finalDest);

                if(ans1==ans2)
                    result.add(finalDest);
            }

            Collections.sort(result);

            for(int j : result)
                sb.append(j).append(" ");
            sb.append("\n");
            graph.clear();
        }
        System.out.print(sb);
    }
}
