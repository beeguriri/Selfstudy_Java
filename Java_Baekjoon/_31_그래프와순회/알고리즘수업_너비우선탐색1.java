package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알고리즘수업_너비우선탐색1 {

    public static int n, m, r;
    public static int[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void bfs(int first){

        Queue<Integer> q = new LinkedList<>();
        int cnt = 1;

        q.offer(first);
        visited[first] = cnt++;

        while(!q.isEmpty()){
            int x = q.poll();
//            System.out.println(x);

            for(int i=0; i<graph.get(x).size(); i++){
                int y = graph.get(x).get(i);
                if(visited[y]==0) {
                    q.offer(y);
                    visited[y] = cnt++;
                }
            }
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //각 노드에 대해 오름차순 정렬
        for(int i=0; i<=n; i++)
            Collections.sort(graph.get(i));

        visited = new int[n+1];
        bfs(r);

        for(int i=1; i<=n; i++)
            System.out.println(visited[i]);
    }
}
