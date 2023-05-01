package Java_Programmers.Level2;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 최댓값과최솟값 {

    public String solution(String s) {

        StringTokenizer st = new StringTokenizer(s);
        List<Integer> list = new ArrayList<>();

        int n = st.countTokens();

        for(int i=0; i<n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        return String.valueOf(list.get(0)) + " " + String.valueOf(list.get(list.size()-1));
    }

}
