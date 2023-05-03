package Java_Baekjoon._22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N과M_4 {

    public static int n, m;
    public static int [] arr;
    public static boolean [] visited;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int depth) {

        if(depth==m){
            for (int i : arr)
                sb.append(i).append(" ");

            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++) {

            if(!visited[i]) {
                arr[depth] = i;
                dfs(depth+1);
                visited[i] = true;
                for(int j=i+1; j<=n; j++)
                    visited[j] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [m];
        visited = new boolean [n+1];

        dfs(0);
        System.out.print(sb);

    }
}
