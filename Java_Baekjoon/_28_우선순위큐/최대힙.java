package Java_Baekjoon._28_우선순위큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 최대힙 {

    /*널리 잘 알려진 자료구조 중 최대 힙이 있다.
    최대 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성하시오.
    1. 배열에 자연수 x를 넣는다.
    2. 배열에서 가장 큰 값을 출력하고, 그 값을 배열에서 제거한다.
    첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
    다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
    만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
    x가 0이라면 배열에서 가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
    입력되는 자연수는 231보다 작다.
    입력에서 0이 주어진 회수만큼 답을 출력한다.
     만약 배열이 비어 있는 경우인데 가장 큰 값을 출력하라고 한 경우에는 0을 출력하면 된다. */

    public static void main(String[] args) throws IOException {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){

            int x = Integer.parseInt(br.readLine());

            if(x!=0)
                maxHeap.offer(x);
            else
                if(maxHeap.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(maxHeap.poll());
        }

    }
}
