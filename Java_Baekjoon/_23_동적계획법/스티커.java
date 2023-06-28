package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스티커 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t=0; t<tc; t++) {

            int n = Integer.parseInt(br.readLine());
            int [][] stikers = new int [2][n+1];
            int [][] d = new int [2][n+1];

            for(int i=0; i<2; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1; j<=n; j++)
                    stikers[i][j] = Integer.parseInt(st.nextToken());
            }

            //제일 첫칸 초기화
            d[0][1] = stikers[0][1];
            d[1][1] = stikers[1][1];

            for(int i=2; i<=n; i++) {
                d[0][i] = Math.max(d[1][i-2], d[1][i-1]) + stikers[0][i];
                d[1][i] = Math.max(d[0][i-2], d[0][i-1]) + stikers[1][i];
            }

            sb.append(Math.max(d[0][n], d[1][n])).append("\n");
        }

        System.out.print(sb);
    }
}
