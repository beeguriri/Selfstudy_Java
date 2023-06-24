package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {

    public static int n;
    public static int [] t;
    public static int [] p;
    public static int [] dp;

    public static int findSum() {

        for(int i=1; i<=n; i++){

            if(i+t[i]<=n+1)
                dp[i+t[i]] = Math.max(dp[i+t[i]], dp[i] + p[i]);

            //현재 날짜에 일할수 없으면 이전까지 일한 금액 넣기
            dp[i+1] = Math.max(dp[i], dp[i+1]);

        }

        return dp[n+1];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        t = new int [n+1];
        p = new int [n+1];
        dp = new int [n+2];

        StringTokenizer st;
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(findSum());
//        System.out.println(Arrays.toString(dp));
    }
}
