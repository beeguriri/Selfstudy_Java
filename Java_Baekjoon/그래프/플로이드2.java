package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 플로이드2 {

    public static final int INF = (int) 1e9;
    public static int n, m;
    public static int [][] graph; // 최소비용 저장
    public static int [][] next; // 도착 직전 도시번호 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        graph = new int [n+1][n+1];
        next = new int [n+1][n+1];

        for(int [] g : graph)
            Arrays.fill(g, INF);

        for(int [] n : next)
            Arrays.fill(n, -1);

        for(int i=0; i<=n; i++)
            for(int j=0; j<=n; j++)
                if(i==j) graph[i][j] = 0;

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a][b] = Math.min(c, graph[a][b]);
            next[a][b] = a;
        }

        for(int k=1; k<=n; k++) {
            for (int a=1; a<=n; a++) {
                for (int b=1; b<=n; b++) {
                    if(graph[a][k] + graph[k][b] < graph[a][b]) {
                        graph[a][b] = graph[a][k] + graph[k][b];
                        next[a][b] = next[k][b];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        //최소비용 출력
        for(int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++){
                if(graph[i][j]==INF)
                    sb.append("0 ");
                else
                    sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }

        //경로 출력
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(next[i][j] == -1)
                    sb.append("0\n");
                else {

                    Stack<Integer> path = new Stack<>();
                    int prev = j;

                    path.push(prev);

                    while(next[i][prev]!=i){
                        prev = next[i][prev];
                        path.push(prev);
                    }

                    //도시의 개수
                    sb.append(path.size() + 1).append(" ");

                    //도시 순으로 출력
                    sb.append(i).append(" ");
                    while(!path.isEmpty()){
                        sb.append(path.pop()).append(" ");
                    }

                    sb.append("\n");
                }
            }
        }

        System.out.println(sb);

    }
}
