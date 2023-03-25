package Java_Baekjoon.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 바이러스 {

    /*입력 :첫째 줄에는 컴퓨터의 수가 주어진다.
    컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
    둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
    이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.
    출력 : 1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
     * */

    public static int com, num;
    public static int [][] list;
    public static boolean [] visited;
    public static int cnt = 0;

    public static  void dfs(int start) {

        visited[start] = true;
        cnt++;

        for(int i = 0 ; i <= com; i++) {
            if(list[start][i] == 1 && !visited[i])
                dfs(i);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        com = Integer.parseInt(br.readLine()); //컴퓨터의 수
        num = Integer.parseInt(br.readLine()); //컴퓨터 쌍의 수

        //입력값 저장 (0번 인덱스 안씀)
        list = new int [com+1][com+1];
        visited = new boolean [com+1];

        for(int i = 0 ; i < num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x][y] = list[y][x] = 1;
        }

        dfs(1);
        //1번 컴퓨터는 countX
        System.out.println(cnt-1);
    }

}
