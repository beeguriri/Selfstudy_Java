package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역 {

    public static int n;
    public static int [][] graph;
    public static boolean [][] visited;

    public static boolean dfs(int x, int y, int max) {

        if(x < 0 || x >= n || y < 0 || y >= n)
            return false;

        if(!visited[x][y] && graph[x][y]>=max){
            visited[x][y] = true;
            dfs(x+1, y, max);
            dfs(x, y+1, max);
            dfs(x-1, y, max);
            dfs(x, y-1, max);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new int [n][n];

        int max = 0;
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, graph[i][j]);
            }
        }

        int count = 0;
        while(max > 0) {
            int cnt = 0;
            visited = new boolean [n][n];
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++){
                    if(dfs(i,j,max))
                        cnt += 1;
                }
            }
            count = Math.max(count, cnt);
            max--;
        }
        System.out.println(count);
    }
}

