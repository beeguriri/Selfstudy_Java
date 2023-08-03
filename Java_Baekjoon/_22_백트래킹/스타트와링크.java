package Java_Baekjoon._22_백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {

    public static int n;
    public static int [][] board;
    public static boolean [] check;
    public static int answer = Integer.MAX_VALUE;

    public static void dfs(int start, int depth) {

        //dfs 종료조건
        if(depth == n/2) {
            //각 팀의 능력치 계산해서 차이가 최소인거 구하기
            int teamA = 0;
            int teamB = 0;
            for(int i=0; i<check.length; i++) {
                for(int j=i+1; j<check.length; j++) {
                    //1, 3, 5번이 팀이면
                    //s13, s31, s15, s51, s35, s53 계산해야됨
                    if(check[i] && check[j]) {
                        teamA += board[i][j];
                        teamA += board[j][i];
                    } else if (!check[i] && !check[j]){
                        teamB += board[i][j];
                        teamB += board[j][i];
                    }
                }
            }

            answer = Math.min(answer, Math.abs(teamA-teamB));
            return;
        }

        for(int i=start; i<n; i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(i+1, depth+1);
                check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        board = new int [n][n];

        StringTokenizer st;

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new boolean [n];
        dfs(0, 0);

        System.out.println(answer);
    }
}
