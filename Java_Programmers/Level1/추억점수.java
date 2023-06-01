package Java_Programmers.Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 추억점수 {

    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int [photo.length];

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++)
            map.put(name[i], yearning[i]);

        for (int i = 0; i < photo.length; i++)
            for(String s : photo[i])
                if(map.get(s)!=null)
                    answer[i] += map.get(s);

        return answer;
    }

    public static void main(String[] args) {

        추억점수 a = new 추억점수();

        String [] name = {"may", "kein", "kain", "radi"};
        int [] yearning = {5, 10, 1, 3};
        String [][] photo = {{"may", "kein", "kain", "radi"},
                {"may", "kein", "brin", "deny"},
                {"kon", "kain", "may", "coni"}};

        System.out.println(Arrays.toString(a.solution(name, yearning, photo)));

    }
}
