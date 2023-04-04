package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 알고리즘수업_깊이우선탐색1 {

    /*깊이 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다.
    첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.
    다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v)
    모든 간선의 (u, v) 쌍의 값은 서로 다르다.
    첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. i번째 줄에는 정점 i의 방문 순서를 출력한다.
    시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
     */

    public static int n, m, r;
    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static int [] visited;
    public static int cnt = 1;

    public static void dfs(int x) {

        visited[x] = cnt++;

        for(int i=0; i<graph.get(x).size(); i++){
            int y = graph.get(x).get(i);

            if(visited[y]==0)
                dfs(y);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i=0; i<=n; i++)
            Collections.sort(graph.get(i));

        visited = new int [n+1];
        dfs(r);

        for(int i=1; i<=n; i++)
            System.out.println(visited[i]);

    }
}
