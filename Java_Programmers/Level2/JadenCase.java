package Java_Programmers.Level2;

import java.util.*;

public class JadenCase {

    public String solution(String s) {

        StringBuilder sb = new StringBuilder();

        s = s.toLowerCase();
        sb.append(s.substring(0,1).toUpperCase());

        for(int i=1; i<s.length(); i++) {

            char x = s.charAt(i);

            if((x>=0 && x<=9) || x==' ')
                sb.append(x);

            else {
                if(s.charAt(i-1)==' ')
                    sb.append(s.substring(i,i+1).toUpperCase());
                else
                    sb.append(x);
            }


        }

        return sb.toString();

    }

    public static void main(String[] args) {

        JadenCase a = new JadenCase();

        System.out.println(a.solution("3people unFollowed me"));
    }

}
