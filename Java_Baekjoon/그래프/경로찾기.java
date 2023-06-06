package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 경로찾기 {

    public static final int INF = (int) 1e9;
    public static int n;
    public static int [][] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int [n][n];

        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {

                int x = Integer.parseInt(st.nextToken());

                if(x==0)
                    graph[i][j] = INF;
                else
                    graph[i][j] = x;
            }
        }

        for(int k=0; k<n; k++) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j]==INF)
                    System.out.print(0 + " ");
                else
                    System.out.print(1 + " ");
            }
            System.out.println();
        }
    }
}
