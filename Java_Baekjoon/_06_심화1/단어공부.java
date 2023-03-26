package Java_Baekjoon._06_심화1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 단어공부 {

    /*알파벳 대소문자로 된 단어가 주어지면,
    이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
    단, 대문자와 소문자를 구분하지 않는다.
    첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
    단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();

        Map<Character, Integer> map = new HashMap<>();
        for(char c : str.toCharArray()){
            if(!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c)+1);
        }

        System.out.println(map);

        int [] values = map.values().stream().sorted().mapToInt(i->i).toArray();
        System.out.println(Arrays.toString(values));

        int max = values[values.length-1];
        String answer = "";

        for(char k : map.keySet()) {
            if(map.get(k)==max) {
                answer += k;
            }
        }

        if(answer.length()==1)
            System.out.println(answer);
        else
            System.out.println("?");

    }
}
