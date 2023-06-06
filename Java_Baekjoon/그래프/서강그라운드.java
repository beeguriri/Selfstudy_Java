package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 서강그라운드 {

    public static final int INF = (int) 1e9;
    public static int n, r;
    public static int m; //수색범위
    public static int [] items;
    public static int [][] graph;

    public static class Node implements Comparable<Node> {

        private final int index;
        private final int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return index;
        }

        public int getDistance() {
            return distance;
        }

        public int compareTo(Node o) {
            return this.distance < o.distance ? -1 : 1;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        items = new int [n+1];
        graph = new int [n+1][n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++)
            items[i] = Integer.parseInt(st.nextToken());

        for(int [] g: graph)
            Arrays.fill(g, INF);

        for(int i=0; i<=n; i++)
            for(int j=0; j<=n; j++)
                if(i==j) graph[i][j] = 0;

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;
            graph[b][a] = c;
        }

        for(int k=1; k<=n; k++)
            for(int a=1; a<=n; a++)
                for(int b=1; b<=n; b++)
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);

        int result = 0;
        for(int i=1; i<=n; i++){
            int temp = 0;
            for(int j=1; j<=n; j++) {
                if(graph[i][j]<=m)
                    temp += items[j];
            }
            result = Math.max(result, temp);
        }

        System.out.println(result);

    }
}
