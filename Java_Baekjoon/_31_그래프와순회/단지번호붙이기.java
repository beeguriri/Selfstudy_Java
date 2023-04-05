package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {

    /*1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
    여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
    대각선상에 집이 있는 경우는 연결된 것이 아니다.
    첫 번째 줄에는 지도의 크기 N(정사각형, 5≤N≤25)이 입력되고,
    그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
    첫 번째 줄에는 총 단지수를 출력하시오.
    그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오. */

    public static int n;
    public static int[][] graph;
    public static boolean[][] visited;
    public static int cnt;
    public static List<Integer> list = new ArrayList<>();

    public static boolean dfs(int x, int y){

        if(x<0 || x>=n || y<0 || y>= n)
            return false;

        if(!visited[x][y] && graph[x][y]==1){
            visited[x][y]=true;
            cnt++;
            dfs(x+1, y);
            dfs(x-1, y);
            dfs(x, y+1);
            dfs(x, y-1);
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        graph = new int [n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                graph[i][j] = Integer.parseInt(s.split("")[j]);
            }
        }

        int result = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(dfs(i,j)){
                    result++;
                    list.add(cnt);
                    cnt=0;
                }
            }
        }
        System.out.println(result);

        Collections.sort(list);

        for(int i=0; i<list.size(); i++)
            System.out.println(list.get(i));

    }
}
