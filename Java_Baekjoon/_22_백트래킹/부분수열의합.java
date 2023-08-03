package Java_Baekjoon._22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 부분수열의합 {

    public static int N, S;
    public static int [] board;
    public static int count;

    public static void dfs(int depth, int sum) {

        //dfs 종료조건
        if(depth==N) {
            if(sum == S)
                count++;
            return;
        }

        dfs(depth+1, sum+board[depth]);
        dfs(depth+1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        board = new int [N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            board[i] = Integer.parseInt(st.nextToken());

        dfs(0, 0);
        count = S==0 ? count-1 : count ;
        System.out.println(count);
    }
}
