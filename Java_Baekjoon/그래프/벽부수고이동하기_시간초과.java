package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 벽부수고이동하기_시간초과 {

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static char [][] graph;
    public static int [][] result;
    public static boolean [][] visited;

    public static void bfs(int x, int y){

        result = new int [n][m];
        visited = new boolean [n][m];

        for(int i=0; i<n; i++)
            Arrays.fill(result[i], INF);

        int [] dx = {1, 0, -1, 0};
        int [] dy = {0, 1, 0, -1};

        Queue<Point> q = new LinkedList<>();

        visited[x][y] = true;
        result[x][y] = 1;

        q.offer(new Point(x, y));

        while(!q.isEmpty()){

            Point p = q.poll();
            int cx = p.getX();
            int cy = p.getY();

            for(int i=0; i<4; i++){

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;

                if(nx == n-1 && ny == m-1) {
                    result[nx][ny] = result[cx][cy] + 1;
                    return;
                }

                if(!visited[nx][ny] && graph[nx][ny]=='0'){
                    visited[nx][ny] = true;
                    result[nx][ny] = Math.min(result[cx][cy] + 1, result[nx][ny]);
                    q.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new char [n][m];


        for(int i=0; i<n; i++)
            graph[i] = br.readLine().toCharArray();

        bfs(0,0);

        int min = result[n-1][m-1];

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(graph[i][j]=='1'){
                    graph[i][j] = '0';
                    bfs(0,0);
                    min = Math.min(min, result[n-1][m-1]);
                    graph[i][j] = '1';
                }
            }
        }

        System.out.println(min==INF? -1 : min);
    }
}
