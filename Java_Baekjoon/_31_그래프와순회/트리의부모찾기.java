package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean [] visited;
    public static int [] parents;

    public static void dfs(int x) {
        visited[x] = true;

        for(int i : graph.get(x)) {
            if(!visited[i]) {
                parents[i] = x;
                dfs(i);
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        visited = new boolean [n+1];
        parents = new int [n+1];

        for(int i=0; i<=n; i++)
            graph.add(new ArrayList<>());

        StringTokenizer st;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dfs(1);

        for(int i=2; i<parents.length; i++)
            System.out.println(parents[i]);
    }
}
