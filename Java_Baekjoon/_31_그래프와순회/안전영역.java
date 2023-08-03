package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 안전영역 {

    public static int n;
    public static int [][] board;
    public static boolean [][] visited;
    public static int [] dx = {-1, 0, 1, 0};
    public static int [] dy = {0, -1, 0, 1};

    public static void bfs(int x, int y, int max) {

        Queue<int []> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new int [] {x, y});

        while(!queue.isEmpty()) {
            int [] now = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0||nx>=n||ny<0||ny>=n)
                    continue;

                if(!visited[nx][ny] && board[nx][ny]>max) {
                    visited[nx][ny] = true;
                    queue.offer(new int [] {nx, ny});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int [n][n];

        int max = 0;
        StringTokenizer st;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, board[i][j]);
            }
        }

        int count = 0;
        for(int target=0; target<max; target++) {
            visited = new boolean[n][n];
            int cnt = 0;
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(!visited[i][j] && board[i][j]>target){
                        bfs(i, j, target);
                        cnt++;
                    }
                }
            }
            count = Math.max(count, cnt);
        }

        System.out.println(count);
    }
}
