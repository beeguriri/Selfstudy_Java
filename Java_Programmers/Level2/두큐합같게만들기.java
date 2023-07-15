package Java_Programmers.Level2;

import java.util.LinkedList;
import java.util.Queue;

public class 두큐합같게만들기 {

    //테스트 11, 28 : 시간초과
    public static int solution(int[] queue1, int[] queue2) {

        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0;
        long sum2 = 0;

        for(int i=0; i<queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];

            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }

        // while문 종료조건 추가
        // 두 큐의 길이가 300,000이므로... 두개 합친값을 종료조건으로 주기
        while(!q1.isEmpty() && !q2.isEmpty() && answer<=600000) {

            if(sum1 == sum2)
                return answer;

            if(sum1 < sum2) {
                int x = q2.poll();
                q1.offer(x);

                sum1 += x;
                sum2 -= x;
                answer++;

            } else {
                int x = q1.poll();
                q2.offer(x);

                sum1 -= x;
                sum2 += x;
                answer++;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

//        System.out.println(solution(new int [] {3, 2, 7, 2}, new int [] {4, 6, 5, 1}));
//        System.out.println(solution(new int [] {1, 2, 1, 2}, new int [] {1, 10, 1, 2}));
        System.out.println(solution(new int [] {1, 1}, new int [] {1, 5}));

    }
}

