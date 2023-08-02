package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 내리막길 {

    public static int m, n;
    public static int [][] board;
    public static int [][] dp;

    public static int [] dx = {-1, 0, 1, 0};
    public static int [] dy = {0, -1, 0, 1};

    public static int bfs(int x, int y) {

        //계단 높이가 더 큰값부터 방문하려고
        PriorityQueue<int []> queue = new PriorityQueue<>(
                (o1, o2) -> board[o2[0]][o2[1]] - board[o1[0]][o1[1]]
        );

        dp[x][y] = 1;
        queue.offer(new int [] {x, y});

        while(!queue.isEmpty()) {

            int [] now = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(board[now[0]][now[1]] <= board[nx][ny])
                    continue;

                if (dp[nx][ny] == 0)
                    queue.offer(new int[]{nx, ny});

                dp[nx][ny] += dp[now[0]][now[1]];

            }
        }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        board = new int [m][n];
        dp = new int [m][n];

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs(0, 0));

    }
}
