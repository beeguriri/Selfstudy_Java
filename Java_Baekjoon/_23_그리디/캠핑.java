package Java_Baekjoon._23_그리디;

import java.io.*;

public class 캠핑 {

    /*캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다.
    강산이는 이제 막 V일짜리 휴가를 시작했다.
    강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)
    각 테스트 케이스는 한 줄로 이루어져 있고, L, P, V를 순서대로 포함하고 있다.
    모든 입력 정수는 int범위이다. 마지막 줄에는 0이 3개 주어진다.
    5 8 20  | Case 1: 14
    5 8 17  | Case 2: 11
    0 0 0
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int i = 0;

        while(!str.equals("0 0 0")) {
            i++;
            int L = Integer.parseInt(str.split(" ")[0]);
            int P = Integer.parseInt(str.split(" ")[1]);
            int V = Integer.parseInt(str.split(" ")[2]);

            int answer = (V/P)*L + Math.min(V%P, L);

            bw.write("Case "+i+": "+answer+"\n");
            str = br.readLine();
        }
        bw.flush();
        bw.close();
    }
}
