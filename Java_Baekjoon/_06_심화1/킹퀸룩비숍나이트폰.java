package Java_Baekjoon._06_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 킹퀸룩비숍나이트폰 {

    /*체스는 총 16개의 피스를 사용하며,
    킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성되어 있다.
    동혁이가 발견한 흰색 피스의 개수가 주어졌을 때, 몇 개를 더하거나 빼야 올바른 세트가 되는지 구하는 프로그램을 작성하시오.*/

    public static void main(String[] args) throws IOException {

        int [] chess = {1, 1, 2, 2, 2, 8};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<chess.length; i++) {
            int x = Integer.parseInt(st.nextToken());
            sb.append(chess[i]-x).append(" ");
        }

        System.out.println(sb);

    }
}
