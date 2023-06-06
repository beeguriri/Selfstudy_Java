package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 서강그라운드v2 {

    public static final int INF = (int) 1e9;
    public static int n, r;
    public static int m; //수색범위
    public static int [] items;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;

    public static class Node implements Comparable<Node> {

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

        public int compareTo(Node o) {
            return this.distance < o.distance ? -1 : 1;
        }
    }

    public static void dijkstra(int start) {

        Queue<Node> q = new PriorityQueue<>();

        Arrays.fill(d, INF);

        d[start] = 0;
        q.offer(new Node(start, 0));

        while(!q.isEmpty()) {

            Node node = q.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now] < dist)
                continue;

            for(int i=0; i<graph.get(now).size(); i++) {

                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost < d[idx]){
                    d[idx] = cost;
                    q.offer(new Node(idx, cost));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int [n+1];
        d = new int [n+1];

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            items[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        int result = 0;
        for(int i=1; i<=n; i++) {
            int temp = 0;
            dijkstra(i);
            for(int j=1; j<=n; j++) {
                if(d[j]<=m)
                    temp += items[j];
            }
            result = Math.max(result, temp);
        }

        System.out.println(result);

    }
}
