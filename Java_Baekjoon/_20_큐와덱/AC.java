package Java_Baekjoon._20_큐와덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class AC {

    /*첫째 줄에 테스트 케이스의 개수 T가 주어진다. T는 최대 100이다.
    각 테스트 케이스의 첫째 줄에는 수행할 함수 p가 주어진다. p의 길이는 1보다 크거나 같고, 100,000보다 작거나 같다.
    다음 줄에는 배열에 들어있는 수의 개수 n이 주어진다. (0 ≤ n ≤ 100,000)
    다음 줄에는 [x1,...,xn]과 같은 형태로 배열에 들어있는 정수가 주어진다. (1 ≤ xi ≤ 100)
    각 테스트 케이스에 대해서, 입력으로 주어진 정수 배열에 함수를 수행한 결과를 출력한다.
    만약, 에러가 발생한 경우에는 error를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t_case = Integer.parseInt(br.readLine());

        for (int t = 0; t < t_case; t++) {

            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            Deque<Integer> q = new LinkedList<>();
            StringBuilder sb = new StringBuilder();

            String s = br.readLine();
            s = s.replaceAll("[\\[\\]]", "");
            StringTokenizer st = new StringTokenizer(s, ",");

            for (int i = 0; i < n; i++)
                q.offer(Integer.parseInt(st.nextToken()));

            boolean dir = true; //first부터 보기
            for (char sel : p.toCharArray()) {

                switch (sel) {

                    case 'R':
                        dir = !dir; //현재 방향의 반대
                        break;

                    case 'D':
                        if (!q.isEmpty()) {
                            if (dir)
                                q.pollFirst();
                            else
                                q.pollLast();
                        } else
                            System.out.println("error");
                        break;
                }
            }
            if(!q.isEmpty()) {
                sb.append("[");
                while (q.size() > 1) {
                    if (dir)
                        sb.append(q.pollFirst()).append(",");
                    else
                        sb.append(q.pollLast()).append(",");
                }
                sb.append(q.poll()).append("]");
                System.out.println(sb);
            }
        }
    }
}
