package Java_Baekjoon._22_백트래킹;

import java.util.Scanner;

public class N과M_2 {

    public static int n, m;
    public static int [] arr;
    public static boolean [] visited;

    public static void dfs(int depth) {

        if(depth==m) {

            StringBuilder sb = new StringBuilder();
            for (int i : arr)
                sb.append(i).append(" ");
            System.out.println(sb);
            return;
        }

        for(int i=1; i<=n; i++){
            if(!visited[i]) {
                visited[i] = true;
                arr[depth] = i;
                dfs(depth+1);
                for(int j=i+1; j<=n; j++)
                    visited[j] = false;
            }
        }

//        for (int i=depth+1; i<=n; i++)
//            visited[i] = false;

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];
        arr = new int [m];

        dfs(0);

    }
}
