package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 운동 {

    public static final int INF = (int) 1e9;
    public static int v, e;
    public static int [][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());

        graph = new int [v+1][v+1];

        for(int [] g : graph)
            Arrays.fill(g, INF);

        for(int i=0; i<=v; i++)
            for(int j=0; j<=v; j++)
                if(i==j)
                    graph[i][j] = 0;

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = c;

        }

        for(int k=1; k<=v; k++)
            for(int a=1; a<=v; a++)
                for(int b=1; b<=v; b++)
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);

        int result = INF;
        for(int i=1; i<=v; i++)
            for (int j = 1; j <= v; j++)
                if(graph[i][j]!=INF && graph[j][i]!=INF && i!=j)
                    result = Math.min(result, graph[i][j] + graph[j][i]);

        if(result != INF)
            System.out.println(result);
        else
            System.out.println(-1);



    }
}
