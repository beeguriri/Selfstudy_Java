package Java_Programmers.Level2;

import java.util.ArrayList;
import java.util.List;

public class 가장큰수 {

    public static String solution(int[] numbers) {

        List<String> list = new ArrayList<>();

        for(int num : numbers)
            list.add(String.valueOf(num));

        list.sort((o1, o2) -> (o2+o1).compareTo(o1+o2));

        System.out.println(list);

        if(list.get(0).equals("0"))
            return "0";

        return String.join("", list);
    }

    public static void main(String[] args) {

        System.out.println(solution(new int [] {6, 10, 2})); //"6210"
        System.out.println(solution(new int [] {3, 30, 34, 5, 9})); //"9534330"

    }
}
