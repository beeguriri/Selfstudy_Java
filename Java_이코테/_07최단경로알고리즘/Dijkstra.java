package Java_이코테._07최단경로알고리즘;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dijkstra {

    private static class Node {

        private final int index; // 노드 번호
        private final int distance; // 간선 길이

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

    // 노드의 개수 n, 간선의 개수 m, 시작번호 start
    // 노드의 개수는 최대 100,000개라고 가정
    public static int n, m, start;

    // 각 노드에 연결 되어 있는 노드에 대한 정보를 담는 배열
    public static List<ArrayList<Node>> graph = new ArrayList<>();

    // 노드 방문 체크용 배열
    public static boolean [] visited;

    // 최단  거리 테이블
    public static int [] d;

    // 방문하지 않은 노드 중에서, 가장 최단거리가 짧은 노드의 번호 반환
    public static int getSamllestNode(){
        int minValue = INF;
        int index = 0;

        for(int i=1; i<=n; i++) {
            if (d[i] < minValue && !visited[i]) {
                minValue = d[i];
                index = i;
            }
        }
        return index;
    }

    public static void dijkstra(int start) {

        // 시작 노드에 대해서 초기화
        d[start] = 0;
        visited[start] = true;
        for (int i=0; i<graph.get(start).size(); i++)
            d[graph.get(start).get(i).getIndex()] = graph.get(start).get(i).getDistance();

        // 시작 노드를 제외한 전체 n-1개의 노드에 대해 반복
        for(int i=0; i<n-1; i++){

            // 현재 최단거리가 가장 짧은 노드부터 탐색 (그리디)
            int now = getSamllestNode();
            visited[now] = true;

            // 현재 노드와 연결 된 다른 노드 확인
            for (int j=0; j<graph.get(now).size(); j++) {
                int no = graph.get(now).get(j).getIndex();
                int cost = d[now] + graph.get(now).get(j).getDistance();
                d[no] = Math.min(cost, d[no]);
            }
        }
    }

    public static void main(String[] args) {

        n = 6;
        m = 11;
        start = 1;

        // 배열 초기화
        visited = new boolean [n+1];
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
