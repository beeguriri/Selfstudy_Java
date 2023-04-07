package Java_Baekjoon._13_정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Collections.max;

public class 로프 {

    /* 여러 개의 로프를 병렬로 연결하면 각각의 로프에 걸리는 중량을 나눌 수 있다.
    k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때,
    각각의 로프에는 모두 고르게 w/k 만큼의 중량이 걸리게 된다.
    첫째 줄에 정수 N이 주어진다.(1 ≤ N ≤ 100,000)
    다음 N개의 줄에는 각 로프가 버틸 수 있는 최대 중량이 주어진다.
    이 값은 10,000을 넘지 않는 자연수이다.
    첫째 줄에 답을 출력한다.
    모든 로프를 사용해야 할 필요는 없으며,
    임의로 몇 개의 로프를 골라서 사용해도 된다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> rope = new ArrayList<>();
        for(int i=0; i<n; i++)
            rope.add(Integer.parseInt(br.readLine()));

        rope.sort(Collections.reverseOrder());

        List<Integer> rope_test = new ArrayList<>();
        for(int i=n; i>=1; i--)
            rope_test.add(rope.get(i-1)*i);

        System.out.println(max(rope_test));

    }
}
