package Java_Baekjoon._20_큐와덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 프린터큐 {

    /*현재 Queue의 가장 앞에 있는 문서의 ‘중요도’를 확인한다.
    나머지 문서들 중 현재 문서보다 중요도가 높은 문서가 하나라도 있다면,
    이 문서를 인쇄하지 않고 Queue의 가장 뒤에 재배치 한다.
    그렇지 않다면 바로 인쇄를 한다.
    첫 줄에 테스트케이스의 수가 주어진다. 각 테스트케이스는 두 줄로 이루어져 있다.
    테스트케이스의 첫 번째 줄에는 문서의 개수 N과,
    몇 번째로 인쇄되었는지 궁금한 문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M
    이때 맨 왼쪽은 0번째라고 하자.(1 ≤ N, M ≤ 100)
    두 번째 줄에는 N개 문서의 중요도가 차례대로 주어진다.
    중요도는 1 이상 9 이하의 정수이고, 중요도가 같은 문서가 여러 개 있을 수도 있다.*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t_case = Integer.parseInt(br.readLine());
        Deque<Map<Integer, Integer>> q = new LinkedList<>();
        List<Map<Integer, Integer>> list = new ArrayList<>();
        StringTokenizer st;

        for(int t=0; t<t_case; t++) {

            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int max = Integer.MIN_VALUE;

            for(int i=0; i<n; i++) {
                Map<Integer, Integer> map = Map.of(i, -1);

            }

        }

    }
}
