package Java_Baekjoon._06_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static java.util.Collections.rotate;

public class 바구니순서바꾸기 {

    /*첫째 줄에 N (1 ≤ N ≤ 100)과 M (1 ≤ M ≤ 100)이 주어진다.
    둘째 줄부터 M개의 줄에는 바구니의 순서를 바꾸는 만드는 방법이 주어진다.
    방법은 i, j, k로 나타내고,
    왼쪽으로부터 i번째 바구니부터 j번째 바구니의 순서를 회전시키는데,
    그 때 기준 바구니는 k번째 바구니라는 뜻이다. (1 ≤ i ≤ k ≤ j ≤ N)
    모든 순서를 회전시킨 다음에, 가장 왼쪽에 있는 바구니부터 바구니에 적혀있는 순서를 공백으로 구분해 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] arr = new int [n];
        for(int i =0; i<n; i++)
            arr[i] = i+1;

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int z = Integer.parseInt(st.nextToken());

            int [] temp = Arrays.copyOfRange(arr, x, y+1);
            System.out.println("temp : " + Arrays.toString(temp));
            List<Integer> list = new ArrayList<>(Arrays.asList(Arrays.stream(temp).boxed().toArray(Integer[]::new)));
            rotate(list, -(z-x)+1);
            System.out.println("rotate : " + list);

            int k = 0;
            for(int j = x; j<=y; j++)
                arr[j] = list.get(k++);

            System.out.println("arr : " + Arrays.toString(arr));
        }

        StringBuilder sb = new StringBuilder();
        for(int a : arr)
            sb.append(a).append(" ");

        System.out.println(sb);
    }
}
