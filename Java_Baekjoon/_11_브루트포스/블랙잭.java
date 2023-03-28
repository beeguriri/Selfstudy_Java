package Java_Baekjoon._11_브루트포스;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 블랙잭 {

    /* N장의 카드 중에서 3장의 카드를 골라야 한다.
    블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
    첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다.
    둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는 양의 정수이다.
    합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.
    출력 : 첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [] cards = new int [n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n ; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        int max = 0;

        for(int i = 0; i < n-2 ; i++) {
            for(int j = i+1; j < n-1; j++) {
                for(int k = j+1; k < n; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (max < sum && sum <= m){
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
