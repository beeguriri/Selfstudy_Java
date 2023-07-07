package Java_Programmers.Level2;

import java.util.*;

public class 모음사전 {

    public static final String [] list = {"A", "E", "I", "O", "U"};

    public static int solution(String word) {

        List<String> dict = new ArrayList<>();

        makeDict(dict, "");

        Collections.sort(dict);

        return dict.indexOf(word);
    }

    public static void makeDict(List<String> dict, String str) {

        if(str.length()>5)
            return;

        if(!dict.contains(str))
            dict.add(str);

        for(String s : list)
            makeDict(dict, str+s);

    }

    public static void main(String[] args) {

        System.out.println(solution("AAAAE")); //6
        System.out.println(solution("AAAE")); //10
        System.out.println(solution("I")); //1563
        System.out.println(solution("EIO")); //1189

    }
}
