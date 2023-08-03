package Java_Baekjoon._31_그래프와순회;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 치킨배달 {

    public static int n, m;
    public static int answer = Integer.MAX_VALUE;
    public static int [][] board;
    public static List<int []> house = new ArrayList<>();
    public static List<int []> chicken = new ArrayList<>();
    public static boolean [] check;

    public static void dfs(int start, int count) {
        //dfs 종료조건
        if(count == m) {
            //거리 계산해서 갱신
            int result = 0;

            for(int i=0; i<house.size(); i++) {

                int distance = Integer.MAX_VALUE;

                //한 집에서 모든 치킨집 까지의 거리 중 최소값 갱신
                for(int j=0; j<chicken.size(); j++)
                    if(check[j])
                        distance = Math.min(distance, calDistance(house.get(i), chicken.get(j)));

                result += distance;
            }
            answer = Math.min(answer, result);
            return;
        }

        for(int i=start; i<chicken.size(); i++) {
            if(!check[i]) {
                check[i] = true;
                dfs(i+1, count+1);
                check[i] = false;
            }
        }
    }

    public static int calDistance(int [] house, int [] chicken) {
        return Math.abs(house[0] - chicken[0]) + Math.abs(house[1] - chicken[1]);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int [n][n];

        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j]==1)
                    house.add(new int [] {i, j});
                if(board[i][j]==2)
                    chicken.add(new int [] {i, j});
            }
        }

        check = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(answer);
    }
}
