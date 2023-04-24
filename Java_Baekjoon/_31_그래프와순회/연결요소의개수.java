package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 연결요소의개수 {

    public static ArrayList<ArrayList<Integer>> board = new ArrayList<>();
    public static int [] visited;

    public static void bfs(int first) {

        Queue<Integer> q = new LinkedList<>();

        if(visited[first]==0) {
            q.offer(first);
            visited[first] = first;
        }

        while(!q.isEmpty()){

            int x = q.poll();

            for(int i=0; i<board.get(x).size(); i++) {

                int y = board.get(x).get(i);

                if(visited[y]==0) {
                    q.offer(y);
                    visited[y] = visited[x];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new int[n+1];

        for(int i=0; i<=n; i++)
            board.add(new ArrayList<>());

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            board.get(u).add(v);
            board.get(v).add(u);
        }

        for(int i=1; i<=n; i++)
            bfs(i);

        Set<Integer> set = new HashSet<>();

        for(int i=1; i<=n; i++)
            set.add(visited[i]);

        System.out.println(set.size());

    }
}
