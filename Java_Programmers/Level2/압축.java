package Java_Programmers.Level2;

import java.util.*;

public class 압축 {

    public static int[] solution(String msg) {

        Map<String, Integer> dict = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        int idx = 1;
        for(int i=0; i<26; i++)
            dict.put(String.valueOf((char)(65+i)), idx++);

        for(int i=0; i<msg.length(); i++){
            int cur = 1;
            while(i+cur<=msg.length() &&
                    dict.containsKey(msg.substring(i, i+cur))){
                cur++;
            }

            //마지막 인덱스 처리
            if(i+cur>msg.length()){
                answer.add(dict.get(msg.substring(i)));
                break;
            }

            //w의 사전index answer에 추가
            answer.add(dict.get(msg.substring(i, i+cur-1)));

            //w+c 문자열 사전에 추가
            dict.put(msg.substring(i, i+cur), idx++);

            //i값 올려주기
            if(cur>1)
                i += (cur-1)-1;
        }

        System.out.println(dict);

        return answer.stream().mapToInt(m -> m).toArray();
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution("KAKAO")));
        System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));

    }
}
