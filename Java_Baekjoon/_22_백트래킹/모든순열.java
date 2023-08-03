package Java_Baekjoon._22_백트래킹;

import java.util.Scanner;

public class 모든순열 {

    public static int N;
    public static int [] result;
    public static boolean [] check;

    public static void dfs(int depth) {

        //dfs 종료조건
        if(depth == N) {
            StringBuilder sb = new StringBuilder();
            for(int i : result)
                sb.append(i).append(" ");

            System.out.println(sb);
            return;
        }

        for(int i=0; i<N; i++) {
            if(!check[i]) {
                check[i] = true;
                result[depth] = i+1;
                dfs(depth+1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        check = new boolean[N];
        result = new int[N];
        dfs(0);
    }
}
