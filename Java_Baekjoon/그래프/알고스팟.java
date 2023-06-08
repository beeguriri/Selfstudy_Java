package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class 알고스팟 {

    static class Point implements Comparable<Point>{
        private int x;
        private int y;
        private int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
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
            return this.count < p.count ? -1 : 1;
        }
    }

    public static int n, m;
    public static boolean [][] visited;
    public static char [][] graph;

    public static int bfs(int x, int y) {

        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, 1, 0, -1};

        Queue<Point> q = new PriorityQueue<>();

        visited[x][y] = true;
        q.offer(new Point(x, y, 0));

        while(!q.isEmpty()) {

            Point now = q.poll();
            int cx = now.getX();
            int cy = now.getY();

            for (int i = 0; i < 4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx == n - 1 && ny == m - 1)
                    return now.getCount();

                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;

                if (!visited[nx][ny] && graph[nx][ny] == '0') {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, now.getCount()));
                }

                if (!visited[nx][ny] && graph[nx][ny] == '1') {
                    visited[nx][ny] = true;
                    q.offer(new Point(nx, ny, now.getCount() + 1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        m = Integer.parseInt(s.split(" ")[0]);
        n = Integer.parseInt(s.split(" ")[1]);

        graph = new char [n][m];
        visited = new boolean [n][m];

        for(int i=0; i<n; i++) {
            char [] ch =  br.readLine().toCharArray();
            for(int j=0; j<m; j++)
                graph[i][j] = ch[j];
        }

        System.out.println(bfs(0,0));

    }
}
