package Java_Baekjoon._23_동적계획법.복습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 평범한배낭 {

    public static int n, k; //물건의 개수, 버틸수 있는 무게
    public static int [][] stuff; //물건의 무게, 가치
    public static int [][] dp; //행이 무게, 열이 개수

    public static int backpack() {

        for(int i=1; i<=k; i++){ //무게탐색
            for(int j=1; j<=n; j++) { //개수탐색
                //i<w : 물건 못넣음
                if(i<stuff[j][0])
                    dp[i][j] = dp[i][j-1];
                //배낭에 물건 추가
                //dp[i-w][j-1] + 현재단계가치 vs 이전단계 가치
                else
                    dp[i][j] = Math.max(dp[i-stuff[j][0]][j-1]+stuff[j][1], dp[i][j-1]);
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        stuff = new int [n+1][2];
        dp = new int [k+1][n+1];

        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            stuff[i][0] = Integer.parseInt(st.nextToken()); //무게
            stuff[i][1] = Integer.parseInt(st.nextToken()); //가치
        }

        System.out.println(backpack());
//        for(int [] d : dp)
//            System.out.println(Arrays.toString(d));
    }
}
