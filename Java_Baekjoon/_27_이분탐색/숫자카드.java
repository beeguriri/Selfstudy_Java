package Java_Baekjoon._27_이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 숫자카드 {

    /*첫째 줄에 상근이가 가지고 있는 숫자 카드의 개수 N(1 ≤ N ≤ 500,000)이 주어진다.
    둘째 줄에는 숫자 카드에 적혀있는 정수가 주어진다.
    숫자 카드에 적혀있는 수는 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다.
    두 숫자 카드에 같은 수가 적혀있는 경우는 없다.
    셋째 줄에는 M(1 ≤ M ≤ 500,000)이 주어진다.
    넷째 줄에는 상근이가 가지고 있는 숫자 카드인지 아닌지를 구해야 할 M개의 정수가 주어지며,
    이 수는 공백으로 구분되어져 있다.
    이 수도 -10,000,000보다 크거나 같고, 10,000,000보다 작거나 같다
    첫째 줄에 입력으로 주어진 M개의 수에 대해서,
    각 수가 적힌 숫자 카드를 상근이가 가지고 있으면 1을, 아니면 0을 공백으로 구분해 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] cards = new int [n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int [] answer = new int [m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            answer[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        StringBuilder sb = new StringBuilder();
        for(int i: answer) {
            int x = Arrays.binarySearch(cards, i);

            if(x>=0)
                sb.append(1).append(" ");
            else
                sb.append(0).append(" ");
        }

        System.out.println(sb);
    }
}
