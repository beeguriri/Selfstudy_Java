package Java_Programmers.Level2;

import java.util.*;

public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> queue = new LinkedList<>();

        if(cacheSize==0){
            answer = 5 * cities.length;
            return answer;
        }

        for(String s : cities) {

            s = s.toLowerCase();

            if(queue.size()<cacheSize) {
                if(queue.contains(s)){
                    queue.remove(s);
                    queue.offer(s);
                    answer += 1;
                } else {
                    queue.offer(s);
                    answer += 5;
                }
            } else {
                if(queue.contains(s)){
                    queue.remove(s);
                    queue.offer(s);
                    answer += 1;
                } else {
                    queue.remove();
                    queue.offer(s);
                    answer += 5;
                }
            }
            // System.out.println(queue);
        }

        return answer;
    }
}
