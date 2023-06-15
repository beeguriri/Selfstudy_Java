package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최소스패닝트리 {

    static class Edge implements Comparable<Edge> {
        private int nodeA;
        private int nodeB;
        private int distance;

        public Edge(int nodeA, int nodeB, int distance) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.distance = distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        public int getDistance() {
            return distance;
        }

        @Override
        public int compareTo(Edge o) {
            return this.distance - o.distance;
        }
    }

    public static int [] parent;
    public static List<Edge> graph = new ArrayList<>();
    public static int v, e;
    public static int result = 0;

    public static int findParent(int x){

        if(x == parent[x])
            return x;

        return findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a>b)
            parent[a] = b;
        else
            parent[b] = a;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        //parent배열 초기화
        parent = new int [v+1];
        for(int i=1; i<=v; i++)
            parent[i] = i;

        for(int i=0; i<e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.add(new Edge(a, b, c));
        }

        Collections.sort(graph);

        //모든 간선 확인
        for(int i=0; i<e; i++) {
            int a = graph.get(i).getNodeA();
            int b = graph.get(i).getNodeB();
            int c = graph.get(i).getDistance();

            if(findParent(a)!=findParent(b)){
                unionParent(a, b);
                result += c;
            }
        }
        System.out.println(result);
    }
}
