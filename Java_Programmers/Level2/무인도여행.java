package Java_Programmers.Level2;

import java.util.*;

public class 무인도여행 {

    public static class Point {

        private final int x;
        private final int y;

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

    public static int [][] newMap;
    public static boolean [][] visited;
    public static int n, m;

    public static int[] solution(String[] maps) {

        List<Integer> result = new ArrayList<>();

        n = maps.length;
        m = maps[0].length();

        newMap = new int [n][m];
        visited = new boolean[n][m];

        for(int i=0; i<n; i++) {
            char[] temp = maps[i].toCharArray();
            for (int j=0; j<m; j++) {
                if (temp[j] == 'X')
                    newMap[i][j] = 0;
                else
                    newMap[i][j] = Integer.parseInt(String.valueOf(temp[j]));

            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(!visited[i][j] && newMap[i][j]!=0) {
                    int x = bfs(i, j);
                    if (x!=0)
                        result.add(x);
                }
            }
        }

        if(result.size()==0)
            return new int [] {-1};

        Collections.sort(result);
        return result.stream().mapToInt(i -> i).toArray();

    }

    public static int bfs(int x, int y) {

        Queue<Point> q = new LinkedList<>();
        int sum = newMap[x][y];
        q.offer(new Point(x, y));
        visited[x][y] = true;

        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};

        while (!q.isEmpty()) {

            Point p = q.poll();
            int cx = p.getX();
            int cy = p.getY();

            for(int i=0; i<4; i++) {

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=m)
                    continue;

                if(!visited[nx][ny] && newMap[nx][ny]!=0) {
                    visited[nx][ny] = true;
                    sum += newMap[nx][ny];
                    q.offer(new Point(nx, ny));
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new String [] {"X591X","X1X5X","X231X", "1XXX1"})));
        System.out.println(Arrays.toString(solution(new String [] {"XXX","XXX","XXX"})));

    }
}
