package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 알파벳 {

    public static int r, c;
    public static int result=1;
    public static char [][] board;
    public static boolean [][] visited;
    public static Set<Character> set = new HashSet<>();

    public static void dfs(int x, int y, int cnt){

        if (x<0 || x>=r || y<0 || y>=c)
            return;

        if(set.contains(board[x][y])) {
            result = Math.max(result, cnt);
            return;
        }

        if(!visited[x][y]) {

            visited[x][y] = true;
            set.add(board[x][y]);

            dfs(x-1, y, cnt+1);
            dfs(x+1, y, cnt+1);
            dfs(x, y-1, cnt+1);
            dfs(x, y+1, cnt+1);

            visited[x][y] = false;
            set.remove(board[x][y]);
            cnt = cnt -1;

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        r = Integer.parseInt(s.split(" ")[0]);
        c = Integer.parseInt(s.split(" ")[1]);

        board = new char [r][c];
        visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            s = br.readLine();
            for(int j=0; j<c; j++)
                board[i][j] = s.charAt(j);
        }

        dfs(0,0,0);

        System.out.println(result);

    }
}
