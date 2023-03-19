package Java_Programmers.Level1;

import java.util.Arrays;
import java.util.HashMap;

public class 대충만든자판 {

    /*1번 키부터 차례대로 할당된 문자들이 순서대로 담긴 문자열배열 keymap과
    입력하려는 문자열들이 담긴 문자열 배열 targets가 주어질 때,
    각 문자열을 작성하기 위해 키를 최소 몇 번씩 눌러야 하는지
    순서대로 배열에 담아 return 하는 solution 함수를 완성해 주세요.
    단, 목표 문자열을 작성할 수 없을 때는 -1을 저장합니다*/

    public int[] solution(String[] keymap, String[] targets) {

        int[] answer = new int [targets.length];
        HashMap<Character, Integer> temp = new HashMap<>();

        //모든 keymap을 hashmap에 추가
        for(String k : keymap) {
            for(int i = 0; i<k.length(); i++) {
                char c = k.charAt(i);
                if(!temp.containsKey(c) || i+1<temp.get(c))
                    temp.put(k.charAt(i), i+1);
            }
        }

        //targets에 대해서 hashmap 탐색
        for(int i = 0; i<targets.length; i++) {
            int res = 0;
            for (int j = 0; j<targets[i].length(); j++) {
                char c = targets[i].charAt(j);
                if(!temp.containsKey(c)){
                    res = -1;
                    break;
                } else
                    res += temp.get(c);
            }
            answer[i] = res;
        }
        return answer;
    }
    public static void main(String[] args) {
        대충만든자판 a = new 대충만든자판();

        String [] key1 = {"ABACD", "BCEFD"};
        String [] targ1 = {"ABCD","AABB"};
        System.out.println(Arrays.toString(a.solution(key1, targ1)));   //[9, 4]

        String [] key2 = {"AA"};
        String [] targ2 = {"B"};
        System.out.println(Arrays.toString(a.solution(key2, targ2)));   //[-1]

        String [] key3 = {"AGZ", "BSSS"};
        String [] targ3 = {"ASA","BGZ"};
        System.out.println(Arrays.toString(a.solution(key3, targ3)));   //[4, 6]

    }
}
