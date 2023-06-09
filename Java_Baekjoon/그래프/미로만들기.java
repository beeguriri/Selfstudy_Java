package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 미로만들기 {

    static class Point implements Comparable<Point> {

        private int x;
        private int y;
        private int count;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.count = cost;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }

        public int compareTo(Point p){
            return this.count - p.count;
        }
    }

    public static int n;
    public static char [][] graph;
    public static boolean [][] visited;

    public static int dijkstra(int x, int y) {

        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, 1, 0, -1};

        Queue<Point> pq = new PriorityQueue<>();

        visited[x][y] = true;
        pq.offer(new Point(0, 0, 0));

        while(!pq.isEmpty()) {

            Point p = pq.poll();
            int cx = p.getX();
            int cy = p.getY();

            for(int i=0; i<4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;

                if(nx == n-1 && ny == n-1)
                    return p.getCount();

                //0이 검은방 (못지나감, 파괴)
                if(!visited[nx][ny] && graph[nx][ny] == '0'){
                    visited[nx][ny] = true;
                    pq.offer(new Point(nx, ny, p.getCount()+1));
                }

                // 1이 흰방 (지나갈수있음)
                if(!visited[nx][ny] && graph[nx][ny] == '1'){
                    visited[nx][ny] = true;
                    pq.offer(new Point(nx, ny, p.getCount()));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new char [n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            char [] temp = br.readLine().toCharArray();
            for(int j=0; j<n; j++)
                graph[i][j] = temp[j];
        }

        System.out.println(dijkstra(0, 0));
    }
}
