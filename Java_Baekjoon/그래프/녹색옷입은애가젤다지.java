package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class 녹색옷입은애가젤다지 {

    static class Node implements Comparable<Node>{
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCost() {
            return cost;
        }

        public int compareTo(Node n) {
            return this.cost < n.getCost() ? -1 : 1;
        }
    }

    public static final int INF = (int) 1e9;
    public static int n;
    public static int [][] graph;
    public static boolean [][] visited;
    public static int [][] result;
    public static int [] dx = {1, 0, -1, 0};
    public static int [] dy = {0, 1, 0, -1};

    public static int dijkstra(int x, int y) {

        Queue<Node> pq = new PriorityQueue<>();
        visited[x][y] = true;
        result[x][y] = graph[x][y];
        pq.offer(new Node(x, y, graph[x][y]));

        while(!pq.isEmpty()) {

            Node node = pq.poll();

            int cx = node.getX();
            int cy = node.getY();
            int cCost = node.getCost();

            for(int i=0; i<4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n )
                    continue;

                if(!visited[nx][ny] && graph[nx][ny] + cCost < result[nx][ny]) {
                    visited[nx][ny] = true;
                    result[nx][ny] = graph[nx][ny] + cCost;
                    pq.offer(new Node(nx, ny, result[nx][ny]));
                }
            }
        }
        return result[n-1][n-1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int idx=1;

        while(true) {

            n = Integer.parseInt(br.readLine());

            if(n==0)
                break;

            graph = new int [n][n];
            visited = new boolean [n][n];
            result = new int [n][n];

            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    result[i][j] = INF;
                }
            }

            System.out.printf("Problem %d: %d\n", idx, dijkstra(0,0));
            idx++;

        }
    }


}
