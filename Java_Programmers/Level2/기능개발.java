package Java_Programmers.Level2;

import java.util.*;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        // int[] answer = {};

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<progresses.length; i++) {
            int x = (int) Math.ceil((double)(100-progresses[i])/speeds[i]);
            q.offer(x);
        };

        // System.out.println(q);
        List<Integer> list = new ArrayList<>();

        int count = 1;
        while(!q.isEmpty()) {
            int x = q.poll();
            while(!q.isEmpty() && q.peek()<=x){
                q.poll();
                count++;
            }
            list.add(count);
            count = 1;
        }
        // System.out.println(list);


        return list.stream().mapToInt(i->i).toArray();
    }
}
