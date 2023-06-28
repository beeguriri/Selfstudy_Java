package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 카드구매하기 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int [] cards = new int [n+1];
        int [] d = new int [n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=1; i<=n; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++)
            for(int j=1; j<=i; j++)
                d[i] = Math.max(d[i], d[i-j]+cards[j]);

        System.out.println(Arrays.toString(d));
        System.out.println(d[n]);
    }
}
