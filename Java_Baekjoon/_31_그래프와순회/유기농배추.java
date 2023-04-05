package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {

    /*0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.
    * 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로
    * 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면
    * 총 몇 마리의 지렁이가 필요한지 알 수 있다.
    * 입력의 첫 줄에는 테스트 케이스의 개수 T가 주어진다.
    * 그 다음 줄부터 각각의 테스트 케이스에 대해
    * 첫째 줄에는 배추를 심은 배추밭의 가로길이 M(1 ≤ M ≤ 50)과 세로길이 N(1 ≤ N ≤ 50),
    * 그리고 배추가 심어져 있는 위치의 개수 K(1 ≤ K ≤ 2500)이 주어진다.
    * 그 다음 K줄에는 배추의 위치 X(0 ≤ X ≤ M-1), Y(0 ≤ Y ≤ N-1)가 주어진다.
    * 두 배추의 위치가 같은 경우는 없다.
    * 각 테스트 케이스에 대해 필요한 최소의 배추흰지렁이 마리 수를 출력한다 */

    public static int n, m, k;
    public static int [][] graph;

    public static boolean dfs(int x, int y) {

        if(x<0 || x>=n || y<0 || y>=m)
            return false;

        if(graph[x][y]==1){

            graph[x][y]=3; //방문처리
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
        int test_case = Integer.parseInt(br.readLine());

        for(int t=0; t<test_case; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            graph = new int [n][m];

            for(int i=0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                graph[x][y] = 1;
            }

            int result = 0;
            for(int i=0; i<n; i++){
                for(int j=0; j<m; j++){
                    if(dfs(i,j))
                        result++;
                }
            }

            System.out.println(result);
        }
    }
}
