package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 적록색약 {

    public static int n;
    public static boolean [][] visited;
    public static char [][] board;

    public static boolean bfs(int x, int y) {

        Queue<int []> queue = new LinkedList<>();
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        char target = board[x][y];
        visited[x][y] = true;
        queue.offer(new int [] {x, y});

        while(!queue.isEmpty()) {
            int [] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for(int i=0; i<4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;

                if(!visited[nx][ny] && board[nx][ny]==target) {
                    visited[nx][ny] = true;
                    queue.offer(new int [] {nx, ny});
                }
            }
        }

        return true;
    }

    public static boolean bfsRG(int x, int y) {

        Queue<int []> queue = new LinkedList<>();
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        char target = board[x][y];
        visited[x][y] = true;
        queue.offer(new int [] {x, y});

        while(!queue.isEmpty()) {
            int [] now = queue.poll();
            int cx = now[0];
            int cy = now[1];

            for(int i=0; i<4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;

                if(!visited[nx][ny]) {
                    if(target=='R' || target=='G') {
                        if(board[nx][ny]=='R' || board[nx][ny]=='G') {
                            visited[nx][ny] = true;
                            queue.offer(new int[]{nx, ny});
                        }
                    } else {
                        if(board[nx][ny]==target) {
                            visited[nx][ny] = true;
                            queue.offer(new int [] {nx, ny});
                        }
                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new char[n][n];

        for(int i=0; i<n; i++){
            String temp = br.readLine();
            board[i] = temp.toCharArray();
        }

        //정상일때
        int count1 = 0;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]){
                    if(bfs(i, j))
                        count1++;
                }
            }
        }

        //적록색약일때
        int count2 = 0;
        visited = new boolean[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j]){
                    if(bfsRG(i, j))
                        count2++;
                }
            }
        }

        System.out.println(count1 + " " + count2);

    }
}
