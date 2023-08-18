package Java_Programmers.Level3;

import java.util.PriorityQueue;
import java.util.Queue;

public class P_05 {

    public static long solution(int n, int[] works) {
        long answer = 0;
        //1번 돌때마다 제일 큰 값에서 1씩 뺀 다음
        //남은거 계산하면 되지않을까?
        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int i : works)
            pq.offer(i);

        while(n>0 && !pq.isEmpty()) {
            int num = pq.poll()-1;
            if (num>0)
                pq.offer(num);
            n--;
        }

        //계산
        while(!pq.isEmpty())
            answer += Math.pow(pq.poll(), 2);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, new int [] {4, 3, 3}));
    }
}
