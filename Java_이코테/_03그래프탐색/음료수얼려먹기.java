package Java_이코테._03그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 음료수얼려먹기 {

    //4 5
    //00110
    //00011
    //11111
    //00000
    //정답 : 3

    /* NxM 얼음틀에 구멍이 뚫려있는 부분은 0, 그렇지 않은 부분은 1입니다.
    구멍이 뚫려있는 부분끼리 상,하,좌,우로 붙어있는 경우 서로 연결되어 있는 것으로 봅니다.
    입력 : 얼음틀의 세로길이 N과 가로길이 M이 주어집니다.
    두번째줄부터 N+1번째줄까지 얼음 틀의 형태가 주어집니다.
    출력 : 한번에 만들 수 있는 아이스크림의 개수를 출력합니다.*/

    //특정 지점의 주변 상,하,좌,우를 살펴본 뒤 주변 지점 중에서 값이 '0'이면서 아직 방문하지않은 지점이 있다면 해당지점 방문
    //방문한 지점에서 다시 상,하,좌,우를 살펴보면서 방문을 진행하는 과정을 반복
    public static int n, m;
    //1 <= n, m <= 1000
    public static int[][] graph = new int[1000][1000];

    public static boolean dfs(int x, int y) {

        //주어진 범위를 벗어나면 즉시 종료
        if (x<0 || x>=n || y<0 || y>=m)
            return false;

        //현재 노드를 아직 방문하지 않았다면
        if(graph[x][y]==0) {

            graph[x][y] = 1; //방문처리

            //상하좌우의 위치들 모두 호출 (재귀)
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String size = br.readLine();
        n = Integer.parseInt(size.split(" ")[0]);
        m = Integer.parseInt(size.split(" ")[1]);

        //입력정보 읽어서 숫자 형태로 저장
        for (int i = 0; i< n; i++) {
            String str = br.readLine();
            for(int j = 0; j<m; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        //모든 노드 방문하기
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(i,j))
                    result += 1;
            }
        }

        System.out.println(result);
    }

}
