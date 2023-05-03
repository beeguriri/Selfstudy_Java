package Java_Baekjoon._22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//System.out.println => 계속 하면 시간초과....ㅋ
public class N과M_3 {

    public static int n, m;
    public static int [] arr;
    public static StringBuilder sb = new StringBuilder();


    public static void dfs(int depth) {

        if(depth == m) {

            for(int i : arr)
                sb.append(i).append(" ");

            sb.append("\n");
            return;
        }

        for(int i=1; i<=n; i++){
            arr[depth] = i;
            dfs(depth+1);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int [m];

        dfs(0);
        System.out.print(sb);

    }
}
