package Java_Programmers.Level2;

import java.util.PriorityQueue;

public class 디펜스게임 {

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0; i<enemy.length; i++) {

            pq.offer(enemy[i]);

            if(pq.size()>k)
                n-=pq.poll();

            if(n<0)
                return i;

        }

        return enemy.length;
    }
}
