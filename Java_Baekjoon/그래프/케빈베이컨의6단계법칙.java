package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙 {

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int [][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new int [n+1][n+1];

        for(int [] g : graph)
            Arrays.fill(g, INF);

        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                if(i==j)
                    graph[i][j] = 0;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a][b] = 1;
            graph[b][a] = 1;

        }

        for(int k=1; k<=n; k++)
            for(int a=1; a<=n; a++)
                for(int b=1; b<=n; b++)
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);


        int result = 0;
        int count = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {

            int temp = 0;

            for (int j = 1; j <= n; j++)
                temp += graph[i][j];

            if(temp < count) {
                count = temp;
                result = i;
            }
        }

        System.out.println(result);

    }
}
