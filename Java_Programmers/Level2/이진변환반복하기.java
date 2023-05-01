package Java_Programmers.Level2;

import java.util.*;

public class 이진변환반복하기 {

    public int[] solution(String s) {
        int[] answer = new int [2];

        int countZero = 0;
        int result = 0;

        while(s.length() >1) {

            for(char c : s.toCharArray()) {
                if(c=='0')
                    countZero +=1;
            }
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            result += 1;
            // System.out.println(s);


        }
        answer[0] = result;
        answer[1] = countZero;

        return answer;
    }
}
