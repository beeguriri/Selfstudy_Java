package Java_이코테._08기타그래프이론;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Kruskal {

    public static int v, e;
    public static int [] parent;
    public static List<Edge> edges = new ArrayList<>();
    public static int result = 0;

    static class Edge implements Comparable<Edge> {

        private final int nodeA;
        private final int nodeB;
        private final int distance;

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
            return this.distance < o.distance ? -1 : 1;
        }
    }


    public static int findParent(int x){
        if(x==parent[x])
            return x;

        else
            return parent[x] = findParent(parent[x]);
    }

    public static void unionParent(int a, int b){
        a = findParent(a);
        b = findParent(b);

        if(a<b)
            parent[b] = a;
        else
            parent[a] = b;
    }

    public static void main(String[] args) {

        //노드와 간선의 개수 입력받기
        v=7; e=9;
        parent = new int [v+1];

        //모든 노드의 부모를 자기자신으로 초기화
        for (int i = 1; i <= v; i++)
            parent[i] = i;

        //간선에 대한 정보 입력받기
        edges.add(new Edge(1, 2, 29));
        edges.add(new Edge(1, 5, 75));
        edges.add(new Edge(2, 3, 35));
        edges.add(new Edge(2, 6, 34));
        edges.add(new Edge(3, 4, 7));
        edges.add(new Edge(4, 6, 23));
        edges.add(new Edge(4, 7, 13));
        edges.add(new Edge(5, 6, 53));
        edges.add(new Edge(6, 7, 25));

        //간선을 비용순으로 정렬
        Collections.sort(edges);

        //간선을 하나씩 확인하여
        for (int i = 0; i < e; i++) {
            int a = edges.get(i).getNodeA();
            int b = edges.get(i).getNodeB();
            int cost = edges.get(i).getDistance();

            //사이클이 발생하지 않는 경우에만 집합에 포함
            if(findParent(a)!=findParent(b)) {
                unionParent(a, b);
                result += cost;
            }
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(result);

    }
}
