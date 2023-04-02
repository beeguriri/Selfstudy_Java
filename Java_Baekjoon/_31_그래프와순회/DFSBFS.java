package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSBFS {

    /*그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
    단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고,
    더 이상 방문할 수 있는 점이 없는 경우 종료한다.
    정점 번호는 1번부터 N번까지이다.
    첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000),
    간선의 개수 M(1 ≤ M ≤ 10,000),
    탐색을 시작할 정점의 번호 V가 주어진다.
    다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다.
    어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다.
    입력으로 주어지는 간선은 양방향이다.
    첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다.
    V부터 방문된 점을 순서대로 출력하면 된다.*/

    public static int n, m, v;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();

    public static void dfs(int first) {

        //현재 노드 방문 처리후, 연결노드 방문
        visited[first] = true;
        System.out.print(first + " "); //1 2 4 3

        for(int i=0; i<graph.get(first).size(); i++){

            int x = graph.get(first).get(i); //4

            if(!visited[x]) {
                dfs(x);
            }
        }
    }

    public static void bfs(int first) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(first);
        visited[first] = true;

        while(!q.isEmpty()) {

            int x = q.poll();
            System.out.print(x + " ");

            for(int i=0; i<graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        //초기화
        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<Integer>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a); //쌍방연결
        }

        for(int i=0; i<=n; i++)
            Collections.sort(graph.get(i));


        visited = new boolean [n+1];
        dfs(v);
        System.out.println();
        visited = new boolean [n+1];
        bfs(v);


    }

}
