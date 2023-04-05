package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탐색 {

    /*미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
    이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
    한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
    첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다.
    다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
    첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다. */

    public static int n, m;
    public static int [] dx = {-1, 0, 1, 0};
    public static int [] dy = {0, -1, 0, 1};
    public static int [][] graph;
    public static boolean [][] visited;

    static class Point {

        private int x;
        private int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public static void bfs(int x, int y){

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){

            Point p = q.poll();

            for(int i=0; i<4; i++){

                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;

                if(!visited[nx][ny] && graph[nx][ny]==1){
                    q.offer(new Point(nx, ny));
                    visited[nx][ny] = true;
                    graph[nx][ny] = graph[p.getX()][p.getY()] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s.split(" ")[0]);
        m = Integer.parseInt(s.split(" ")[1]);

        graph = new int [n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++){
            s = br.readLine();
            for(int j=0; j<m; j++){
                graph[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        bfs(0, 0);
        System.out.println(graph[n-1][m-1]);

    }
}
