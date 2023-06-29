package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 동전1 {

    public static int n, k;
    public static int [] coins;
    public static int [] d;

    public static int dp() {

        d[0] = 1;

        for(int i=0; i<n; i++)
            for(int j=coins[i]; j<=k; j++)
                d[j] += d[j-coins[i]];

        return d[k];
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int [n];
        d = new int [k+1];

        for(int i=0; i<n; i++)
            coins[i] = Integer.parseInt(br.readLine());

        System.out.println(dp());
    }
}
