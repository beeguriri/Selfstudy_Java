package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 지름길 {

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
            return this.distance < o.distance ? -1 : 1;
        }
    }

    public static int n, d;
    public static List<List<Node>> graph = new ArrayList<>();
    public static int [] dist;

    public static void dijkstra() {

        for(int i=0; i<=d; i++){

            if(i!=0)
                dist[i] = Math.min(dist[i], dist[i-1]+1);

            if(graph.get(i).size()>0) {
                for(int j=0; j<graph.get(i).size(); j++) {
                    int idx = graph.get(i).get(j).getIndex();
                    int cost = dist[i] + graph.get(i).get(j).getDistance();

                    if(cost<dist[idx])
                        dist[idx] = cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for(int i=0; i<=d; i++)
            graph.add(new ArrayList<>());

        dist = new int [d+1];
        for(int i=0; i<=d; i++)
            dist[i] = i;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(b-a < c)
                continue;

            if (b>d)
                continue;

            graph.get(a).add(new Node(b, c));
        }

        dijkstra();
        System.out.println(dist[d]);

    }
}
