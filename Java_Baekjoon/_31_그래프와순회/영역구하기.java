package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 영역구하기 {

    public static int m, n, k;
    public static boolean [][] visited;
    public static int [][] graph;

    public static int bfs(int x, int y) {

        int count = 1;
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0, -1, 0, 1};
        Queue<int []> queue = new LinkedList<>();

        visited[x][y] = true;
        queue.offer(new int [] {x, y});

        while(!queue.isEmpty()) {
            int [] now = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx<0 || nx>=m || ny<0 || ny>=n)
                    continue;

                if(!visited[nx][ny] && graph[nx][ny]==0){
                    visited[nx][ny] = true;
                    queue.offer(new int [] {nx, ny});
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new int [m][n];
        visited = new boolean[m][n];

        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());
            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            for(int x=x1; x<x2; x++) {
                for(int y=y1; y<y2; y++) {
                    graph[x][y] = 1;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && graph[i][j]==0) {
                    answer.add(bfs(i, j));
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for(int i : answer)
            System.out.print(i + " ");

    }
}
