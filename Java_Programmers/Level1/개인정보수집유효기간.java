package Java_Programmers.Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 개인정보수집유효기간 {

    /*당신은 오늘 날짜로 파기해야 할 개인정보 번호들을 구하려 합니다.
    모든 달은 28일까지 있다고 가정합니다.
    today는 "YYYY.MM.DD" 형태로 오늘 날짜를 나타냅니다.
    terms의 원소는 약관 종류와 유효기간을 공백 하나로 구분한 문자열입니다.
    약관 종류는 A~Z중 알파벳 대문자 하나,유효기간은 개인정보를 보관할 수 있는 달 수를 나타내는 정수이며, 1 이상 100 이하
     privacies의 원소는 날짜와 약관 종류를 공백 하나로 구분한 문자열입니다.
     날짜는 "YYYY.MM.DD" 형태의 개인정보가 수집된 날짜를 나타내며, today 이전의 날짜만 주어집니다.*/

    public int[] solution(String today, String[] terms, String[] privacies) {

        String [] save = new String [privacies.length];

        //terms를 hashmap으로 변환
        HashMap<String, Integer> temp = new HashMap<>();
        for(String t : terms)
            temp.put(t.substring(0,1), Integer.parseInt(t.substring(2)));

        //보관가능일자
        for(int i = 0; i<privacies.length; i++) {
            int privY = Integer.parseInt(privacies[i].substring(0,4));
            int privM = Integer.parseInt(privacies[i].substring(5,7));
            int privD = Integer.parseInt(privacies[i].substring(8,10));
            String type = privacies[i].substring(11);
            save[i] = "";

            privY = privY + temp.get(type)/12;
            privM = privM + temp.get(type)%12;
            privD = privD - 1;

            if(privM>12) {
                privY = privY + 1;
                privM = privM - 12;
            }

            if(privD==0) {
                if(privM-1!=0) {
                    privM = privM - 1;
                    privD = 28;
                } else {
                    privY = privY - 1;
                    privM = 12;
                    privD = 28;
                }
            }
            save[i] = String.valueOf(privY)+".";
            save[i] += String.valueOf(privM).length()==1? "0"+String.valueOf(privM)+".": String.valueOf(privM)+".";
            save[i] += String.valueOf(privD).length()==1? "0"+String.valueOf(privD): String.valueOf(privD);
        }

        //today랑 비교해서 파기여부 결정
        ArrayList<Integer> exp = new ArrayList<>();
        for(int i = 0; i<save.length; i++) {
            if(save[i].compareTo(today)<0)
                exp.add(i+1);
        }

        int[] answer = new int [exp.size()];
        for(int i = 0; i<exp.size(); i++)
            answer[i] = exp.get(i);

        return answer;
    }

    public static void main(String[] args) {
        개인정보수집유효기간 a = new 개인정보수집유효기간();

        String [] terms1 = {"A 6", "B 12", "C 3"};
        String [] priv1 = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        System.out.println(Arrays.toString(a.solution("2022.05.19", terms1, priv1))); //[1, 3]

        String [] terms2 = {"Z 3", "D 5"};
        String [] priv2 = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        System.out.println(Arrays.toString(a.solution("2020.01.01", terms2, priv2))); //[1, 4, 5]

    }
}
