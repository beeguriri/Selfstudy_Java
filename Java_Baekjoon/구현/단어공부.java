package Java_Baekjoon.구현;

import java.util.*;

public class 단어공부 {

    /*알파벳 대소문자로 된 단어가 주어지면,
    이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오.
    단, 대문자와 소문자를 구분하지 않는다.
    입력 : 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다.
    주어지는 단어의 길이는 1,000,000을 넘지 않는다.
    출력 : 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다.
    단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
     */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.next().toUpperCase();
        String [] strA = str.split("");

        Map<String, Integer> map = new HashMap<>();
        for(String s : strA) {
            if(map.containsKey(s))
                map.put(s, map.get(s)+1);
            else
                map.put(s, 1);
        }

        System.out.println(map);

        String answer = "";
        int max = Integer.MIN_VALUE;
        int temp = 0;

        for(String k : map.keySet()) {

            int cnt = map.get(k);

            if(max < cnt) {
                max = cnt;
                answer = k;
            } else if (max == cnt) {
                temp = cnt;
            }
        }

        if(temp == max) {
            System.out.println("?");
        } else {
            System.out.println(answer);
        }



        //Mississipi => ?
        //zZa => Z
        //z => Z
        //baaa => A

    }
}
