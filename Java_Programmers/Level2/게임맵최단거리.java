package Java_Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {

    public static class Point {
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

    public static boolean [][] visited;
    public static int [][] board;

    //0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타
    public static int solution(int[][] maps) {

        visited = new boolean [maps.length][maps[0].length];
        board = new int [maps.length][maps[0].length];

        bfs(0, 0, maps);

        if(board[maps.length-1][maps[0].length-1]==0)
            return -1;
        else
            return board[maps.length-1][maps[0].length-1];
    }

    public static void bfs(int x, int y, int [][] maps){

        Queue<Point> queue = new LinkedList<>();

        int [] dx = {-1, 1, 0, 0}; //상하
        int [] dy = {0, 0, -1, 1}; //좌우

        queue.offer(new Point(x, y));
        visited[x][y] = true;
        board[x][y] = 1;

        while(!queue.isEmpty()) {

            Point p = queue.poll();
            int cx = p.getX();
            int cy = p.getY();

            for(int i=0; i<4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=maps.length || ny<0 || ny>=maps[0].length)
                    continue;

                if(!visited[nx][ny] && maps[nx][ny]==1) {
                    visited[nx][ny] = true;
                    board[nx][ny] = board[cx][cy] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }

    }

    public static void main(String[] args) {

        int [][] maps1 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps1)); //11
        int [][] maps2 = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
        System.out.println(solution(maps2)); //-1
    }
}
