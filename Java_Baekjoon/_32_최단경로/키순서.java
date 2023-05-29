package Java_Baekjoon._32_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키순서 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean [][] graph = new boolean [n+1][n+1];

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = true;
        }

        for (int k = 1; k <= n; k++) {
            for (int a = 1; a <= n; a++) {
                for (int b = 1; b <=n; b++) {
                    if(graph[a][k] && graph[k][b])
                        graph[a][b] = true;
                }
            }
        }

        int [] ans = new int [n+1];

        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(graph[i][j] || graph[j][i])
                    ans[i] += 1;
            }
        }

        int result = 0;
        for(int i: ans)
            if(i == n-1)
                result += 1;

        System.out.println(result);

    }
}
