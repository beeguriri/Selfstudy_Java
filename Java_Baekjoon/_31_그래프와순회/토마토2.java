package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토2 {

    static class Point3 {

        private int z;
        private int x;
        private int y;

        public Point3(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }
    }

    public static Queue<Point3> q = new LinkedList<>();
    public static int [][][] board;
    public static int result;
    public static int m,n,h;

    public static void bfs(){

        int [] dz = {-1, 1, 0, 0, 0, 0};
        int [] dx = {0, 0, -1, 1, 0, 0};
        int [] dy = {0, 0, 0, 0, -1, 1};

        while(!q.isEmpty()){

            Point3 p = q.poll();

            for(int i=0; i<6; i++){

                int nz = p.getZ() + dz[i];
                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];

                if(nz<0 || nz>=h || nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;

                if(board[nz][nx][ny]==0) {
                    board[nz][nx][ny] = board[p.getZ()][p.getX()][p.getY()] + 1;
                    q.offer(new Point3(nz, nx, ny));
                }

            }
        }

    }

    public static int checkBfs(){

        int max = Integer.MIN_VALUE;

        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(board[i][j][k]==0)
                        return -1;

                    max = Math.max(max, board[i][j][k]);
                }
            }
        }

        if(max ==1)
            return 0;
        else
            return max-1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new int [h][n][m];

        for(int i=0; i<h; i++) {
            for(int j=0; j<n; j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<m; k++) {
                    board[i][j][k] = Integer.parseInt(st.nextToken());

                    if(board[i][j][k]==1)
                        q.offer(new Point3(i,j,k));
                }
            }
        }

        bfs();
        System.out.println(checkBfs());

    }
}
