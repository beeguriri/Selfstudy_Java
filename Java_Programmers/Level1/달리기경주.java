package Java_Programmers.Level1;

import java.util.*;
import static java.util.Collections.*;

public class 달리기경주 {

    public String[] solution(String[] players, String[] callings) {

        Map <String, Integer> map = new HashMap<>();

        for(int i=0; i<players.length; i++)
            map.put(players[i], i);

        // System.out.println(map);
        for(String s : callings) {

            int idx = map.get(s);
            String prev = players[idx-1];

            //순위 바꿔주고
            map.put(prev, map.get(prev)+1);
            map.put(s, map.get(s)-1);

            //배열에도 반영
            players[idx] = prev;
            players[idx-1] = s;

            // System.out.println(map);
        }

        return players;
    }


    //시간초과
    public String[] solution1(String[] players, String[] callings) {
        String[] answer = new String [players.length];

        List<String> list = new ArrayList<>(Arrays.asList(players));
        // System.out.println(list);

        for(String s : callings){
            int idx = list.indexOf(s);
            // System.out.println(idx);
            swap(list, idx, idx-1);
            // System.out.println(list);
        }

        int idx = 0;
        for(String s : list)
            answer[idx++] = s;

        return answer;
    }
}
