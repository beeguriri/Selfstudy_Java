package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 암기왕 {

    /*첫째 줄에 테스트케이스의 개수 T가 들어온다.
    다음 줄에는 ‘수첩 1’에 적어 놓은 정수의 개수 N(1 ≤ N ≤ 1,000,000)이 입력으로 들어온다.
    그 다음 줄에 ‘수첩 1’에 적혀 있는 정수들이 N개 들어온다.
    그 다음 줄에는 ‘수첩 2’에 적어 놓은 정수의 개수 M(1 ≤ M ≤ 1,000,000) 이 주어지고,
    다음 줄에 ‘수첩 2’에 적어 놓은 정수들이 입력으로 M개 들어온다.
    모든 정수들의 범위는 int 로 한다.
    ‘수첩2’에 적혀있는 M개의 숫자 순서대로, ‘수첩1’에 있으면 1을, 없으면 0을 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {

            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++)
                set.add(Integer.parseInt(st.nextToken()));

            int m = Integer.parseInt(br.readLine());
            int [] ans = new int [m];
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<m; j++) {
                ans[j] = Integer.parseInt(st.nextToken());
                if(set.contains(ans[j]))
                    sb.append(1).append("\n");
                else
                    sb.append(0).append("\n");
            }

            System.out.print(sb);




        }
    }
}
