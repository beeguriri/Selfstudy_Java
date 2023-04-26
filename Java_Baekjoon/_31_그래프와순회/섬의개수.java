package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수 {

    /*입력은 여러 개의 테스트 케이스로 이루어져 있다.
    각 테스트 케이스의 첫째 줄에는 지도의 너비 w와 높이 h가 주어진다.
     w와 h는 50보다 작거나 같은 양의 정수이다.
    둘째 줄부터 h개 줄에는 지도가 주어진다. 1은 땅, 0은 바다이다.
    입력의 마지막 줄에는 0이 두 개 주어진다.
    각 테스트 케이스에 대해서, 섬의 개수를 출력한다.*/

    public static int w, h;
    public static int [][] board;
    public static boolean [][] visited;

    public static boolean dfs(int x, int y) {

        if (x<0 || x>=h || y<0 || y>=w)
            return false;

        if(!visited[x][y] && board[x][y]==1){
            visited[x][y] = true;
            dfs(x-1, y);
            dfs(x+1, y);
            dfs(x, y-1);
            dfs(x, y+1);
            dfs(x-1, y-1);
            dfs(x-1, y+1);
            dfs(x+1, y-1);
            dfs(x+1, y+1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {

            String s = br.readLine();
            if(s.equals("0 0"))
                break;

            w = Integer.parseInt(s.split(" ")[0]); //column
            h = Integer.parseInt(s.split(" ")[1]); //row

            board = new int [h][w];
            visited = new boolean [h][w];

            boolean isOne = false;
            for(int i=0; i<h; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                    if(board[i][j]==1)
                        isOne = true;
                }
            }

            int result = 0;

            if(!isOne)
                System.out.println(result);
            else {
                for (int i = 0; i < h; i++) {
                    for (int j = 0; j < w; j++) {
                        if(dfs(i, j))
                            result++;
                    }
                }
                System.out.println(result);
            }
        }
    }
}
