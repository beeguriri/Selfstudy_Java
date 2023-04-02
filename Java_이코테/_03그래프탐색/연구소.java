package Java_이코테._03그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연구소 {

    //시작점 기준 0,0
    public static int n, m;
    public static int result = Integer.MIN_VALUE;
    //(3 <= n, m <= 8)
    public static int[][] arr; // 초기 맵 배열
    public static int[][] temp; // 벽을 설치한 뒤의 맵 배열

    // 4가지 이동 방향에 대한 배열
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    //바이러스 전파
    public static void virus(int x, int y) {

        for(int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<n && ny>=0 && ny<m){
                if (temp[nx][ny] == 0) {
                    temp[nx][ny] = 2; //바이러스배치
                    virus(nx, ny);
                }
            }
        }
    }

    //안전영역 계산 메서드
    public static int getScore() {

        int score = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(temp[i][j]==0)
                    score++;
            }
        }
        return score;
    }

    //벽 세우기
    public static void dfs(int count) {

        //count ==3
        if(count==3) {
            //검사용 배열 세팅
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++)
                    temp[i][j] = arr[i][j];
            }

            //바이러스 전파
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(temp[i][j]==2)
                        virus(i,j);
                }
            }

            //안전영역 카운트
            result = Math.max(result, getScore());
            return;
        }

        //count != 3
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++) {
                if(arr[i][j]==0) {
                    arr[i][j]=1;
                    count += 1;
                    dfs(count);
                    //dfs 실패 시 상태 되돌림
                    arr[i][j]=0;
                    count -= 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        temp = new int[n][m];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(result);
    }

}
