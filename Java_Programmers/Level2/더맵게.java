package Java_Programmers.Level2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 더맵게 {
    //섞은 음식의 S = 가장 맵지 않은 음식의 S + (두 번째로 맵지 않은 음식의 S*2)
    //Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
    //Leo가 가진 음식의 스코빌 지수를 담은 배열 scoville과 원하는 스코빌 지수 K가 주어질 때,
    //모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return 하도록 solution 함수를 작성해주세요.

    public static int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        for(int i : scoville)
            pq.offer(i);

        while(!pq.isEmpty() && pq.peek()<K){

            //모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우에는 -1을 return 합니다.
            if(pq.size()<2 && pq.peek()<K)
                return -1;

            int x = pq.poll();
            int y = pq.poll() * 2;
            pq.offer(x+y);
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int [] {10, 12, 3, 9, 1, 2}, 7)); //2
        System.out.println(solution(new int [] {1, 1, 1}, 100)); //2

    }
}
