package Java_이코테._07최단경로알고리즘;

import java.util.Arrays;

public class 미래도시 {

    public static final int INF = (int) 1e9;

    public static void main(String[] args) {

        int n = 5;
        int m = 7;
        int [][] graph = new int [n+1][n+1];

        // graph를 INF로 채우고
        for(int i=0; i<=n; i++)
            Arrays.fill(graph[i], INF);

        // 주대각선을 0으로 채우고
        for(int i=1; i<=n; i++)
            for (int j=1; j<=n; j++)
                if(i==j)
                    graph[i][j] = 0;

        // 입력값으로 초기화
        // 문제조건 : 양방향
        graph[1][2] = 1; graph[2][1] = 1;
        graph[1][3] = 1; graph[3][1] = 1;
        graph[1][4] = 1; graph[4][1] = 1;
        graph[2][4] = 1; graph[4][2] = 1;
        graph[3][4] = 1; graph[4][3] = 1;
        graph[3][5] = 1; graph[5][3] = 1;
        graph[4][5] = 1; graph[5][4] = 1;

        //점화식에 따라 최소거리 구하기
        for(int k=1; k<=n; k++)
            for(int a=1; a<=n; a++)
                for(int b=1; b<=n; b++)
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);

        // 1번에서 시작해서 k번 회사를 거쳐 x번 회사로 가는 최소 이동시간
        int x = 4;
        int k = 5;
        int dist = graph[1][k] + graph[k][x];

        if(dist >= INF)
            System.out.println(-1); //도달할 수 없는 경우
        else
            System.out.println(dist);

    }
}
