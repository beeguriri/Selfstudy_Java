package Java_Programmers.Level2;

import java.util.*;

public class 의상 {

    public int solution(String[][] clothes) {

        Map<String, Integer> map = new HashMap<>();

        for(String [] c : clothes)
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);

        // System.out.println(map);

        int answer = 1;

        for (int v : map.values())
            answer *= (v+1);

        return answer-1;
    }
}
