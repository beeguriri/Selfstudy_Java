package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소비용구하기2 {

    static class Node implements Comparable<Node>{
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

        public int compareTo(Node o){
            return this.distance - o.distance;
        }
    }

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static List<ArrayList<Node>> graph = new ArrayList<>();
    public static int [] d;
    public static int [] cities;

    public static int dijkstra(int start, int end) {

        Queue<Node> pq = new PriorityQueue<>();
        d[start] = 0;
        cities[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){

            Node node = pq.poll();
            int now = node.getIndex();
            int dist = node.getDistance();

            if(d[now]<dist)
                continue;

            for(int i=0; i<graph.get(now).size(); i++){

                int idx = graph.get(now).get(i).getIndex();
                int cost = d[now] + graph.get(now).get(i).getDistance();

                if(cost<d[idx]){
                    d[idx] = cost;
                    pq.offer(new Node(idx, cost));
                    cities[idx] = now;
                }
            }
        }

        return d[end];
    }

    public static void findCities(int start, int end) {

        List<Integer> result = new ArrayList<>();

        int now = end;

        while(now!=0) {
            result.add(now);
            now = cities[now];
        }

        System.out.println(result.size());

        for(int i=result.size()-1; i>=0; i--)
            System.out.print(result.get(i) + " ");

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        d = new int [n+1];
        cities = new int [n+1];

        Arrays.fill(d, INF);
        Arrays.fill(cities, -1);

        StringTokenizer st;
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b, c));
            cities[b] = a;
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end =  Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(start, end));

        findCities(start, end);

    }

}
