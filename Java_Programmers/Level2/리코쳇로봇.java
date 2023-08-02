package Java_Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 리코쳇로봇 {

    public static int min = Integer.MAX_VALUE;
    public static int m, n;
    public static char [][] graph;

    public static void bfs(int x, int y) {

        Queue<int []> queue = new LinkedList<>();
        boolean [][] visited = new boolean [m][n];
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        visited[x][y] = true;
        queue.offer(new int [] {x, y, 0});

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            if(graph[now[0]][now[1]]=='G') {
                min = Math.min(min, now[2]);
                return;
            }

            for(int i=0; i<4; i++) {

                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>= n)
                    continue;

                if(graph[nx][ny]=='D')
                    continue;

                while(nx>=0 && ny>=0 && nx<m && ny<n && graph[nx][ny]!='D') {
                    nx += dx[i];
                    ny += dy[i];
                }

                nx -= dx[i];
                ny -= dy[i];

                if(!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new int [] {nx, ny, now[2]+1});
                }
            }
        }
    }

    public int solution(String[] board) {
        m = board.length;
        n = board[0].length();

        int sx = 0;
        int sy = 0;

        graph = new char[m][n];
        for(int i=0; i<m; i++) {
            String temp = board[i];
            for(int j=0; j<n; j++) {
                graph[i][j] = temp.charAt(j);

                if(graph[i][j]=='R') {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs(sx, sy);


        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
