package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ATM {

    /*첫째 줄에 사람의 수 N(1 ≤ N ≤ 1,000)이 주어진다.
    둘째 줄에는 각 사람이 돈을 인출하는데 걸리는 시간 Pi가 주어진다. (1 ≤ Pi ≤ 1,000)
    첫째 줄에 각 사람이 돈을 인출하는데 필요한 시간의 합의 최솟값을 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] pi = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            pi[i] = Integer.parseInt(st.nextToken());


        Arrays.sort(pi);

        int total = 0;
        int prev = 0;

        for(int t : pi) {
            prev += t;
            total += prev;
        }

        System.out.println(total);

    }
}
