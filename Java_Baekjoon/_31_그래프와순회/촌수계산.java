package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 촌수계산 {

    public static int n, m;
    public static int result = -1;
    public static boolean [] visited;
    public static List<ArrayList<Integer>> list = new ArrayList<>();

    public static void dfs(int start, int end, int count) {

        if(start==end) {
            result = count;
            return;
        }

        visited[start] = true;

        for(int i : list.get(start))
            if(!visited[i])
                dfs(i, end, count+1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());


        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited = new boolean [n+1];
        dfs(x, y, 0);
        System.out.println(result);

    }
}
