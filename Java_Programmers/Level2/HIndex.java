package Java_Programmers.Level2;

import java.util.*;

public class HIndex {

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);
        // System.out.println(Arrays.toString(citations));

        for(int i=0; i<citations.length; i++) {

            if(citations.length-i <= citations[i]) {
                answer = citations.length-i;
                // System.out.println(answer);
                break;
            }

        }

        return answer;
    }
}
