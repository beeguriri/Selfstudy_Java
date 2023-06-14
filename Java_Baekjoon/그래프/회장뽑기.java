package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회장뽑기 {

    public static final int INF = (int) 1e9;
    public static int n;
    public static int [][] graph;

    public static void fw(){

        for(int k=1; k<=n; k++)
            for(int a=1; a<=n; a++)
                for(int b=1; b<=n; b++)
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int [n+1][n+1];

        for(int i=0; i<=n; i++)
            Arrays.fill(graph[i], INF);

        for(int i=0; i<=n; i++)
            for(int j=0; j<=n; j++)
                if(i==j) graph[i][j] = 0;

        while(true) {
            String s = br.readLine();

            if(s.equals("-1 -1"))
                break;

            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);

            graph[a][b] = 1;
            graph[b][a] = 1;

        }

        fw();

        int min = INF;
        List<Integer> candidates = new ArrayList<>();

        for(int i=1; i<=n; i++) {
            int max = 0;
            for (int j=1; j<=n; j++)
                max = Math.max(max, graph[i][j]);

            min = Math.min(min, max);
        }

        for(int i=1; i<=n; i++) {
            int temp = 0;
            for (int j=1; j<=n; j++)
                temp = Math.max(temp, graph[i][j]);

            if(temp == min)
                candidates.add(i);
        }

        Collections.sort(candidates);
        System.out.println(min + " " + candidates.size());
        for(int i: candidates)
            System.out.print(i + " ");

    }
}
