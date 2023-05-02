package Java_Programmers.Level2;

import java.util.*;

public class 영어끝말잇기 {

    public int[] solution(int n, String[] words) {
        int[] answer = new int [2];

        Set <String> set = new HashSet<>();

        set.add(words[0]);

        for (int i=1; i<words.length; i++) {

            char prev = words[i-1].charAt(words[i-1].length()-1);
            char now = words[i].charAt(0);

            // System.out.println(prev + ", " + now);

            if(prev==now && !set.contains(words[i]))
                set.add(words[i]);
            else {

                answer[0] = (i+1) % n == 0 ? n : (i+1) % n;
                answer[1] = (i/n) + 1;
                break;
            }
        }

        // System.out.println(set);

        return answer;
    }
}
