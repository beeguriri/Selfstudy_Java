package Java_Programmers.Level2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 호텔대실2 {

    public static int solution(String[][] book_time) {
        Arrays.sort(book_time,
                (o1, o2) -> calcTime(o1[0])==calcTime(o2[0]) ? calcTime(o1[1]) - calcTime(o2[1]) : calcTime(o1[0]) - calcTime(o2[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(String [] booking : book_time){

            if(pq.isEmpty()) {
                pq.offer(calcTime(booking[1])+10);
                continue;
            }

            if(calcTime(booking[0])>=pq.peek()){
                pq.poll();
            }

            pq.offer(calcTime(booking[1])+10);
        }

        return pq.size();
    }

    public static int calcTime(String s) {
        String [] temp = s.split(":");
        return Integer.parseInt(temp[0])*60 + Integer.parseInt(temp[1]);
    }

    public static void main(String[] args) {
        System.out.println(solution(new String [][] {{"15:00", "17:00"}, {"16:40", "18:20"},
                {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}}));
    }
}
