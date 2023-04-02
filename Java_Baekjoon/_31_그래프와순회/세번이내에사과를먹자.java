package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 세번이내에사과를먹자 {

    /*5 x 5 크기의 보드가 주어진다. 보드는 1 x 1 크기의 정사각형 격자로 이루어져 있다.
    보드의 격자는 사과가 1개 있는 격자, 장애물이 있는 격자, 빈칸으로 되어 있는 격자로 구분된다.
    격자의 위치는 (r, c)로 표시한다. r은 행 번호, c는 열 번호를 나타낸다.
    맨 왼쪽 위 위치가 (0, 0), 맨 아래 오른쪽 위치가 (4, 4)이다.
    현재 한 명의 학생이 (r, c) 위치에 있고 한 번의 이동으로 상, 하, 좌, 우 방향 중에서 한가지 방향으로 한 칸 이동할 수 있다.
    학생이 사과가 있는 칸으로 이동하면 해당 칸에 있는 사과를 1개 먹는다.
    장애물이 있는 칸으로는 이동할 수 없다.
    학생이 지나간 칸은 학생이 해당 칸을 떠나는 즉시 장애물이 있는 칸으로 변경된다.
    즉, 학생이 해당 칸에서 상, 하, 좌, 우 방향으로 한 칸 이동하는 즉시 해당 칸은 장애물이 있는 칸으로 변경된다.
    첫 번째 줄부터 다섯 개의 줄에 걸쳐 보드의 정보가 주어진다.
    i번째 줄의 j번째 수는 보드의 (i - 1)번째 행, (j - 1)번째 열의 정보를 나타낸다.
    1이면 해당 칸은 사과가 1개 있는 격자, 0이면 빈칸, -1이면 장애물이 있는 격자임을 나타낸다.
    첫 번째 줄에 현재 위치 (r, c)에서 세 번 이하의 이동으로 사과를 2개 이상 먹을 수 있으면 1을 출력하고, 먹을 수 없으면 0을 출력한다.*/

    public static int r, c;
    public static int [][] board = new int [5][5];
    //public static boolean [][] visited = new boolean[5][5];

    public static int [] dx = {-1 , 1 , 0 , 0};
    public static int [] dy = {0 , 0 , -1 , 1};

    public static int cnt = 0;
    public static int moves = 0;

    public static void dfs(int r, int c) {
        //visited[x][y] = true;
        if (board[r][c]==1) {
            cnt++;
            board[r][c] = -1;
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr<0 || nr >5 || nc < 0 || nc >5 || board[nr][nc]==-1)
                continue;

            if(board[nr][nc]==0 || board[nr][nc]==1) {
                moves++;
                if(board[nr][nc]==1)
                    cnt++;

                if(moves<=3 && cnt>=2) {
                    System.out.println("1");
                    System.exit(0);
                } else if (moves>3) {
                    cnt = 0;
                    moves = 0;
                    break;
                }

                board[nr][nc] = -1;
                dfs(nr, nc);
            }




        }





    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0 ; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //처음 위치
        String s = br.readLine();
        r = Integer.parseInt(s.split(" ")[0]);
        c = Integer.parseInt(s.split(" ")[1]);

        dfs(r, c);
        System.out.println("0");
    }
}
