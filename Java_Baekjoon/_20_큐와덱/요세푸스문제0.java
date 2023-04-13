package Java_Baekjoon._20_큐와덱;

import java.util.*;

public class 요세푸스문제0 {

    /*1번부터 N번까지 N명의 사람이 원을 이루면서 앉아있고, 양의 정수 K(≤ N)가 주어진다.
    이제 순서대로 K번째 사람을 제거한다.
    이 과정은 N명의 사람이 모두 제거될 때까지 계속된다*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        for(int i=1; i<=n; i++)
            q.offer(i);

        while(q.size()>1){
            for(int i=1; i<=k-1; i++) {
                q.offer(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }

        sb.append(q.poll()).append(">");

        System.out.println(sb);

    }
}
