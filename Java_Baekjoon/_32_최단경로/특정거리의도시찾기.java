package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 특정거리의도시찾기 {

    static class Node implements Comparable<Node> {
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

        public int compareTo(Node o){
            return this.distance < o.distance ? -1 : 1;
        }
    }

    public static final int INF = (int) 1e9;
    public static int n, m, k, x;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    public static void dijkstra(int start){

        PriorityQueue<Node> pq = new PriorityQueue<>();
        Arrays.fill(d, INF);
        d[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {

            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now]<dist)
                continue;

            for(int i=0; i<graph.get(now).size(); i++){

                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost<d[idx]) {
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도시 개수
        m = Integer.parseInt(st.nextToken()); // 도로 개수
        k = Integer.parseInt(st.nextToken()); // 거리 정보
        x = Integer.parseInt(st.nextToken()); // 출발 도시 번호

        d = new int [n+1];
        for (int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, 1));
        }

        dijkstra(x);

        List<Integer> result = new ArrayList<>();
        for(int i=1; i<=n; i++)
            if(d[i]==k)
                result.add(i);

        if(result.size()==0)
            System.out.println(-1);
        else {
            Collections.sort(result);
            for(int c : result)
                System.out.println(c);
        }
    }
}

