package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 나이트의이동 {

    /*입력의 첫째 줄에는 테스트 케이스의 개수가 주어진다.
    각 테스트 케이스는 세 줄로 이루어져 있다.
    첫째 줄에는 체스판의 한 변의 길이 l(4 ≤ l ≤ 300)이 주어진다. 체스판의 크기는 l × l이다.
    체스판의 각 칸은 두 수의 쌍 {0, ..., l-1} × {0, ..., l-1}로 나타낼 수 있다.
    둘째 줄과 셋째 줄에는 나이트가 현재 있는 칸, 나이트가 이동하려고 하는 칸이 주어진다.
    각 테스트 케이스마다 나이트가 최소 몇 번만에 이동할 수 있는지 출력한다. */

    public static int n;
    public static int [][] visited;
    public static int sx, sy;
    public static int ex, ey;

    static class KnightPoint{

        private int x;
        private int y;

        KnightPoint(int x, int y) {
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

    public static boolean bfs(int x, int y){

        visited = new int [n][n];
        int [] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int [] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        Queue<KnightPoint> q = new LinkedList<>();
        q.offer(new KnightPoint(x, y));
        visited[x][y] = 1;

        while(!q.isEmpty()){

            KnightPoint current = q.poll();
            int cx = current.getX();
            int cy = current.getY();

            if(cx==ex && cy==ey)
                return true;

            for(int i=0; i<8; i++){

                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx<0 || nx>=n || ny<0 || ny>=n)
                    continue;

                if(visited[nx][ny]==0){
                    q.offer(new KnightPoint(nx, ny));
                    visited[nx][ny] = visited[cx][cy] + 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numCase = Integer.parseInt(br.readLine());

        for(int c=0; c<numCase; c++){
            n = Integer.parseInt(br.readLine());
            String startS = br.readLine();
            String endS = br.readLine();

            sx = Integer.parseInt(startS.split(" ")[0]);
            sy = Integer.parseInt(startS.split(" ")[1]);
            ex = Integer.parseInt(endS.split(" ")[0]);
            ey = Integer.parseInt(endS.split(" ")[1]);

            if(sx==ex && sy==ey || !bfs(sx, sy))
                System.out.println("0");
            else
                System.out.println(visited[ex][ey]-1);
        }
    }
}
