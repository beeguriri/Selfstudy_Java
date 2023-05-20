package Java_이코테._07최단경로알고리즘;

import java.util.Arrays;

public class Floyd_Warshall {

    public static final int INF = (int) 1e9;

    // 노드의 개수는 최대 500개라고 가정
    public static int n, m;
    public static int [][] graph;

    public static void main(String[] args) {

        n = 4; m=7;
        graph = new int [n+1][n+1];
        // 그래프는 INF 값으로 초기화
        for(int i=0; i<=n; i++)
            Arrays.fill(graph[i], INF);

        // 자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화 (대각선)
        for(int i=1; i<=n; i++)
            for(int j=1; j<=n; j++)
                if(i==j)
                    graph[i][j] = 0;

        // 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
        // 행이 출발, 열이 도착
        graph[1][2] = 4; graph[1][4] = 6;
        graph[2][1] = 3; graph[2][3] = 7;
        graph[3][1] = 5; graph[3][4] = 4;
        graph[4][3] = 2;

        // 점화식에 따라 플로이드 워셜 알고리즘 수행
        // d_ab = min(d_ab, d_ak + d_kb)
        for(int k=1; k<=n; k++)
            for(int a=1; a<=n; a++)
                for(int b=1; b<=n; b++)
                    graph[a][b] = Math.min(graph[a][b], graph[a][k]+graph[k][b]);

        // 결과 출력
        for (int i=1; i<=n; i++){
            for (int j=1; j<=n; j++){
                if(graph[i][j]==INF)
                    System.out.print("I ");
                else
                    System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
