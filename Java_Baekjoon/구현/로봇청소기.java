package Java_Baekjoon.구현;

import java.beans.Visibility;
import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 로봇청소기 {

    public static int n, m;
    public static int [][] graph;
    public static boolean [][] visited;
    public static int [] dr = {-1, 0, 1, 0}; //0일때 북쪽, 1일때 동쪽
    public static int [] dc = {0, 1, 0, -1}; //2일때 남쪽, 3일때 서쪽
    public static int cnt = 0;

    public static void clean(int r, int c, int d) {

        boolean check = false;

        // 현재칸이 청소 되지 않았을 경우 청소한다
        if(!visited[r][c] && graph[r][c]==0) {
            visited[r][c] = true;
            cnt += 1;
        }

        // 4방향 중 청소되지않은 칸 있는지 확인
        for (int i = 0; i < 4; i++) {

            //반시계방향으로 90도 회전
            d = nextDirection(d);

            int nr = r + dr[d];
            int nc = c + dc[d];

            if(!visited[nr][nc] && graph[nr][nc]==0){
                clean(nr, nc, d);
                check = true;
                break;
            }
        }

        // 청소되지않은 빈 칸이 없는 경우,
        if(!check) {
            //바라보는 방향을 유지한채로 한칸 후진
            int nr = r - dr[d];
            int nc = c - dc[d];

            if(graph[nr][nc]==0)
                clean(nr, nc, d);

        }
    }

    public static int nextDirection(int d) {

        if(d==0)
            return 3;
        else if(d==1)
            return 0;
        else if(d==2)
            return 1;
        else
            return 2;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int [n][m];
        visited = new boolean [n][m];

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++)
                graph[i][j] = Integer.parseInt(st.nextToken());
        }

        clean(r,c,d);
        System.out.println(cnt);

    }
}
