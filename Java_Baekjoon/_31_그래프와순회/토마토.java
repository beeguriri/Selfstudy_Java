package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    /*첫 줄에는 상자의 크기를 나타내는 두 정수 M,N이 주어진다.
    M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다.
    단, 2 ≤ M,N ≤ 1,000 이다.
    둘째 줄부터는 하나의 상자에 저장된 토마토들의 정보가 주어진다.
    즉, 둘째 줄부터 N개의 줄에는 상자에 담긴 토마토의 정보가 주어진다.
    하나의 줄에는 상자 가로줄에 들어있는 토마토의 상태가 M개의 정수로 주어진다.
    정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. */

    static class Point2{

        private int x;
        private int y;

        public Point2(int x, int y) {
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
    }

    public static int [][] board;
    public static int result;
    public static Queue<Point2> q = new LinkedList<>();

    public static void bfs() {

        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};

        while(!q.isEmpty()) {

            Point2 p = q.poll();

            for(int i=0; i<4; i++){

                int nx = p.getX() + dx[i];
                int ny = p.getY() + dy[i];

                if(nx<0 || ny<0 || nx>= board.length || ny >= board[0].length)
                    continue;

                if(board[nx][ny]==0) {
                    board[nx][ny] = board[p.getX()][p.getY()] + 1;
                    q.offer(new Point2(nx, ny));
                }
            }
        }
    }

    public static int checkBfs(){

        int max = Integer.MIN_VALUE;

        for(int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if(board[i][j]==0)
                    return -1;

                max = Math.max(max, board[i][j]);
            }
        }

        if(max==1)
            return 0;
        else
            return max-1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken()); //가로칸수
        int n = Integer.parseInt(st.nextToken()); //세로칸수

        board = new int [n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j]==1)
                    q.offer(new Point2(i, j));
            }
        }

        bfs();
        System.out.println(checkBfs());

    }
}
