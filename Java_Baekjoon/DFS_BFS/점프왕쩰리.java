package Java_Baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 점프왕쩰리 {

    /*쩰리’는 가로와 세로의 칸 수가 같은 정사각형의 구역 내부에서만 움직일 수 있다.
    ‘쩰리’가 정사각형 구역의 외부로 나가는 경우엔 바닥으로 떨어져 즉시 게임에서 패배하게 된다.
    ‘쩰리’의 출발점은 항상 정사각형의 가장 왼쪽, 가장 위의 칸이다. 다른 출발점에서는 출발하지 않는다.
    ‘쩰리’가 이동 가능한 방향은 오른쪽과 아래 뿐이다. 위쪽과 왼쪽으로는 이동할 수 없다.
    ‘쩰리’가 가장 오른쪽, 가장 아래 칸에 도달하는 순간, 그 즉시 ‘쩰리’의 승리로 게임은 종료된다.
    ‘쩰리’가 한 번에 이동할 수 있는 칸의 수는, 현재 밟고 있는 칸에 쓰여 있는 수 만큼이다.
    칸에 쓰여 있는 수 초과나 그 미만으로 이동할 수 없다.
    입력의 첫 번째 줄에는 게임 구역의 크기 N (2 ≤ N ≤ 3)이 주어진다.
    입력의 두 번째 줄부터 마지막 줄까지 게임판의 구역(맵)이 주어진다.
    게임판의 승리 지점(오른쪽 맨 아래 칸)에는 -1이 쓰여있고, 나머지 칸에는 0 이상 100 이하의 정수가 쓰여있다.
    ‘쩰리’가 끝 점에 도달할 수 있으면 “HaruHaru”, 도달할 수 없으면 “Hing”출력합니다.*/

    public static int n;
    public static int [][] board;
    public static boolean [][] visited;

    public static int [] dx = {1, 0};
    public static int [] dy = {0, 1};

    public static void dfs(int x, int y) {

        visited[x][y] = true;

        if(board[x][y] == -1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for(int i = 0; i<2; i++) {
            int nx = x + dx[i]*board[x][y];
            int ny = y + dy[i]*board[x][y];

            if(nx >= n || ny >= n || visited[nx][ny])
                continue;

            visited[nx][ny] = true;
            dfs(nx, ny);

        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();
        n = Integer.parseInt(size.split(" ")[0]);

        board = new int [n][n];
        visited = new boolean[n][n];

        //입력값 처리
        for(int i = 0; i < n; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //호출
        dfs(0,0);
        System.out.println("Hing");

    }

}
