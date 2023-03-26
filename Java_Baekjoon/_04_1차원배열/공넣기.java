package Java_Baekjoon._04_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공넣기 {

    /*도현이는 바구니를 총 N개 가지고 있고, 각각의 바구니에는 1번부터 N번까지 번호가 매겨져 있다.
    또, 1번부터 N번까지 번호가 적혀있는 공을 매우 많이 가지고 있다.
    가장 처음 바구니에는 공이 들어있지 않으며, 바구니에는 공을 1개만 넣을 수 있다.
    첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
    둘째 줄부터 M개의 줄에 걸쳐서 공을 넣는 방법이 주어진다.
    각 방법은 세 정수 i j k로 이루어져 있으며,
    i번 바구니부터 j번 바구니까지에 k번 번호가 적혀져 있는 공을 넣는다는 뜻이다.
    1번 바구니부터 N번 바구니에 들어있는 공의 번호를 공백으로 구분해 출력한다.
    공이 들어있지 않은 바구니는 0을 출력한다.
     */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];

        for(int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());
            for(int j = x; j <= y; j++) {
                arr[j] = z;
            }
        }
        //System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for(int a : arr)
            sb.append(String.valueOf(a)).append(" ");

        sb.append("\n");
        System.out.println(sb);
    }
}
