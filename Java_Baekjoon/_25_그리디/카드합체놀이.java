package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 카드합체놀이 {

    /*첫 번째 줄에 카드의 개수를 나타내는 수 n(2 ≤ n ≤ 1,000)과
    카드 합체를 몇 번 하는지를 나타내는 수 m(0 ≤ m ≤ 15×n)이 주어진다.
    두 번째 줄에 맨 처음 카드의 상태를 나타내는 n개의 자연수 a1, a2, …, an이 공백으로 구분되어 주어진다.
    (1 ≤ ai ≤ 1,000,000)*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> cards = new PriorityQueue<>();

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            cards.offer(Long.parseLong(st.nextToken()));

        for(int i=0; i<m; i++) {

            long x = cards.poll();
            long y = cards.poll();
            cards.offer(x+y);
            cards.offer(x+y);
        }

        long sum = 0;
        while(!cards.isEmpty())
            sum += cards.poll();

        System.out.println(sum);

    }
}
