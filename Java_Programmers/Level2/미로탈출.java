package Java_Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    static class Point {

        private final int x;
        private final int y;
        private final int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getCount() {
            return count;
        }
    }

    public static char [][] board;
    public static boolean [][] visited;
    public static int row;
    public static int col;

    public static int solution(String[] maps) {

        row = maps.length;
        col = maps[0].length();

        board = new char[row][col];

        for(int i=0; i<row; i++) {
            String temp = maps[i];
            board[i] = temp.toCharArray();
        }

        int [] start = new int [2];
        int [] lever = new int [2];

        for(int i=0; i<row; i++) {
            for (int j=0; j<col; j++) {
                if (board[i][j] == 'S')
                    start = new int [] {i, j};

                if (board[i][j] == 'L')
                    lever = new int [] {i, j};
            }
        }

        int result1 = bfs(start[0], start[1], 'L');
        int result2 = bfs(lever[0], lever[1], 'E');

        return (result1==-1 || result2 ==-1) ? -1 : result1 + result2;
    }

    public static int bfs(int x, int y, char target) {

        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};

        Queue<Point> queue = new LinkedList<>();
        visited = new boolean[row][col];

        visited[x][y] = true;
        queue.offer(new Point(x, y, 0));

        while(!queue.isEmpty()) {

            Point p = queue.poll();
            int cx = p.getX();
            int cy = p.getY();
            int count = p.getCount();

            if(board[cx][cy]==target)
                return count;

            for(int i=0; i<4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=row || ny<0 || ny>=col)
                    continue;

                if(!visited[nx][ny] && board[nx][ny] != 'X') {

                    visited[nx][ny] = true;
                    queue.offer(new Point(nx, ny, count+1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(solution(new String [] {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"})); //16
        System.out.println(solution(new String [] {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"})); //-1

    }
}
