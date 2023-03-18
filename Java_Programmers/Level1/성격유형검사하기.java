package Java_Programmers.Level1;

import java.util.HashMap;

public class 성격유형검사하기 {

    /*성격지표 AN :
    1 : 매우 비동의	어피치형 3점
    2 : 비동의	어피치형 2점
    3 : 약간 비동의	어피치형 1점
    4 : 모르겠음	어떤 성격 유형도 점수를 얻지 않습니다
    5 : 약간 동의	네오형 1점
    6 : 동의	네오형 2점
    7 : 매우 동의	네오형 3점*/

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        HashMap<String, Integer> temp = new HashMap<>();
        temp.put("R", 0);   temp.put("T", 0);   temp.put("C", 0);   temp.put("F", 0);
        temp.put("J", 0);   temp.put("M", 0);   temp.put("A", 0);   temp.put("N", 0);

        for(int i = 0; i<survey.length; i++) {
            int score = scores(choices[i]);
            String [] type = survey[i].split("");
            if(choices[i]/4 ==0) {
                int x = temp.get(type[0])+score;
                temp.put(type[0],x);
            } else {
                int x = temp.get(type[1])+score;
                temp.put(type[1],x);
            }
        }

        if(temp.get("R")>=temp.get("T")) answer += "R";
        else answer += "T";

        if(temp.get("C")>=temp.get("F")) answer += "C";
        else answer += "F";

        if(temp.get("J")>=temp.get("M")) answer += "J";
        else answer += "M";

        if(temp.get("A")>=temp.get("N")) answer += "A";
        else answer += "N";

        return answer;
    }
    public int scores(int n) {
        switch (n) {
            case 1, 7 :
                return 3;
            case 2, 6 :
                return 2;
            case 3, 5 :
                return 1;
            default:
                return 0;
        }
    }
    public static void main(String[] args) {
        성격유형검사하기 a = new 성격유형검사하기();

        String [] sur = {"AN", "CF", "MJ", "RT", "NA"};
        int [] choi = {5, 3, 2, 7, 5};
        System.out.println(a.solution(sur,choi)); //TCMA

        String [] sur2 = {"TR", "RT", "TR"};
        int [] choi2 = {7, 1, 3};
        System.out.println(a.solution(sur2, choi2)); //RCJA

    }
}
