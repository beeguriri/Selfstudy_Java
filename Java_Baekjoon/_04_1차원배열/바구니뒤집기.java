package Java_Baekjoon._04_1차원배열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 바구니뒤집기 {

    /*첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
    둘째 줄부터 M개의 줄에는 바구니의 순서를 역순으로 만드는 방법이 주어진다.
    방법은 i j로 나타내고, 왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 역순으로 만든다는 뜻이다.
    (1 ≤ i ≤ j ≤ N)
    도현이는 입력으로 주어진 순서대로 바구니의 순서를 바꾼다.
    모든 순서를 바꾼 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];
        for(int i = 0; i<n; i++)
            arr[i] = i+1;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;

            int [] temp = Arrays.copyOfRange(arr, x, y+1);

            for(int j = temp.length-1; j >= 0; j--)
                arr[x++] = temp[j];
        }
        StringBuilder sb = new StringBuilder();
        for(int a : arr)
            sb.append(String.valueOf(a)).append(" ");

        sb.append("\n");
        System.out.println(sb);
    }
}
