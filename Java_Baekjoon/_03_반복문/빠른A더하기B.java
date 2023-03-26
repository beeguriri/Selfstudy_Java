package Java_Baekjoon._03_반복문;

import java.io.*;
import java.util.StringTokenizer;

public class 빠른A더하기B {

    //BufferedReader와 BufferedWriter 사용

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            bw.write(a+b + "\n");
        }

        bw.flush();
        bw.close();
    }
}
