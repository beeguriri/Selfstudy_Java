package Java_Baekjoon.그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울 {

    public static final int INF = (int) 1e9;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        boolean [][] graph = new boolean [n+1][n+1];

        for(int i=0; i<=n; i++)
            Arrays.fill(graph[i],false);

        for(int i=0; i<=n; i++)
            for(int j=0; j<=n; j++)
                if(i==j) graph[i][j] = true;

        StringTokenizer st;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            //비교 결과가 모순되는 입력은 없다고 가정한다.
            //[1]>[2], [2]>[3]이므로 우리는 [1]>[3]이라는 것을 예측할 수 있는데,
            //[3]>[1]과 서로 모순이므로 이러한 입력은 가능하지 않다.
            if(!graph[a][b]) {
                graph[a][b] = true;
            }
        }

        for(int k=1; k<=n; k++) {
            for(int a=1; a<=n; a++) {
                for(int b=1; b<=n; b++) {
                    if(graph[a][k] && graph[k][b])
                        graph[a][b] = true;

                }
            }
        }

//        for(int i=1; i<=n; i++){
//            for(int j=1; j<=n ; j++) {
//                System.out.print(graph[i][j] + " ");
//            }
//            System.out.println();
//        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            int count = 0;
            for(int j=1; j<=n; j++){
                if(!graph[i][j] && !graph[j][i])
                    count += 1;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);


    }
}

