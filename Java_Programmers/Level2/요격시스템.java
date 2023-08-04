package Java_Programmers.Level2;

import java.util.Arrays;

public class 요격시스템 {

    public int solution(int[][] targets) {

        Arrays.sort(targets, (o1, o2) -> o1[1]==o2[1] ? o1[0]-o2[0] : o1[1] - o2[1]);

        int answer = 1;
        int last = targets[0][1];

        for(int [] target : targets) {
            if(target[0]>=last) {
                answer++;
                last = target[1];
            }
        }

        return answer;
    }
}
