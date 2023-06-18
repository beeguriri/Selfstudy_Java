package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기 {

    static class Point{
        int x;
        int y;
        int count;
        boolean destroyed;

        public Point(int x, int y, int count, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.destroyed = destroyed;
        }
    }

    public static int n, m;
    public static char [][] graph;
    public static boolean [][][] visited;
    public static int [] dx = {1, 0, -1, 0};
    public static int [] dy = {0, 1, 0, -1};

    public static int bfs() {

        Queue<Point> q = new LinkedList<>();

        //x, y, count, destroyed
        q.offer(new Point(0, 0, 1, false));
        visited[0][0][0] = true;

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(p.x == n-1 && p.y == m-1)
                return p.count;

            for(int i=0; i<4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;

                //벽을 부순적이 있을 때
                if(p.destroyed) {
                    //그래프는 벽이 아니어야 하며, 방문한 적이 없어야함
                    if(graph[nx][ny]=='0' && !visited[nx][ny][1]) {
                        visited[nx][ny][1] = true;
                        q.offer(new Point(nx, ny, p.count+1, true));
                    }
                }
                //벽을 부순적이 없을 때
                else {
                    //벽이면 부수고 넣기
                    if(graph[nx][ny] == '1' && !visited[nx][ny][0]) {
                        visited[nx][ny][1] = true;
                        q.offer(new Point(nx, ny, p.count+1, true));
                    }
                    //벽이 아니면 방문처리만 하기
                    else if (!visited[nx][ny][0]){
                        visited[nx][ny][0] = true;
                        q.offer(new Point(nx, ny, p.count+1, false));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char [n][m];
        visited = new boolean[n][m][2];


        for(int i=0; i<n; i++)
            graph[i] = br.readLine().toCharArray();

        System.out.println(bfs());
    }
}
