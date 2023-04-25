package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 연구소 {

    public static int n, m;
    public static int [][] board;
    public static int [][] temp;
    public static int result = Integer.MIN_VALUE;

    public static void virus(int x, int y) {

        int [] dx = {-1, 1, 0, 0};
        int [] dy = {0, 0, -1, 1};

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=m)
                continue;

            if(temp[nx][ny]==0) {
                temp[nx][ny] = 2;
                virus(nx, ny);
            }
        }
    }

    public static int getSafe(){

        int cnt = 0;

        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if(temp[i][j]==0)
                    cnt++;
            }
        }

        return cnt;
    }

    public static void dfs(int count) {

        if(count == 3) {

            // 검사용 배열 셋팅
            for(int i=0; i<n; i++)
                for(int j=0; j<m; j++)
                    temp[i][j] = board[i][j];

            // 바이러스 퍼트리기
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++) {
                    if(temp[i][j]==2)
                        virus(i,j);
                }
            }

            // 안전영역 개수 구하기
            result = Math.max(result, getSafe());

            return;
        }

        // 벽 세우기
        for(int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if(board[i][j]==0) {
                    board[i][j] = 1;
                    count++;
                    dfs(count);
                    // 벽 세우기 실패할 경우 원상복구
                    count--;
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int [n][m];
        temp = new int [n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++)
                board[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(result);

    }
}
