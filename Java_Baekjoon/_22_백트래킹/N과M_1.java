package Java_Baekjoon._22_백트래킹;

import java.util.Scanner;

public class N과M_1 {

    public static int n, m;
    public static int [] arr;
    public static boolean [] visited;

    public static void dfs(int depth){

        if(depth == m) {
            StringBuilder sb = new StringBuilder();

            for(int i : arr)
                sb.append(i).append(" ");

            System.out.println(sb);
            return;

        }

        for(int i=1; i<=n; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[depth] = i;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int [m];
        visited = new boolean [n+1];

        dfs(0);

    }
}

