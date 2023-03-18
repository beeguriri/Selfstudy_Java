package Java_Programmers.Level1;

import java.util.Arrays;
import java.util.LinkedList;

public class 완주하지못한선수 {

    /*마라톤에 참여한 선수들의 이름이 담긴 배열 participant와
    완주한 선수들의 이름이 담긴 배열 completion이 주어질 때,
    완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
    참가자 중에는 동명이인이 있을 수 있습니다.*/

    public String solution(String[] participant, String[] completion) {

        Arrays.sort(participant);
        Arrays.sort(completion);

        LinkedList<String> temp = new LinkedList<>(Arrays.asList(participant));
        for (String s : completion) {
            if (temp.get(0).equals(s))
                temp.remove(0);
            else if (temp.get(1).equals(s))
                temp.remove(1);
        }

        //효율성테스트 -_-
        //제거 시 arraylist보다 linked-list가 빠르다!
//        ArrayList<String> temp = new ArrayList<>();
//        temp.addAll(Arrays.asList(participant));
//        for(String c : completion) {
//            for (int i = 0; i<participant.length; i++) {
//                if(temp.get(i).equals(c)) {
//                    temp.remove(c);
//                    break;
//                }
//            }
//        }

        return temp.get(0);
    }

    public static void main(String[] args) {

        완주하지못한선수 a = new 완주하지못한선수();

        String [] participant1 = {"leo", "kiki", "eden"};
        String [] completion1 = {"eden", "kiki"};
        System.out.println(a.solution(participant1, completion1)); //"leo"

        String [] participant2 = {"mislav", "stanko", "mislav", "ana"};
        String [] completion2 = {"stanko", "ana", "mislav"};
        System.out.println(a.solution(participant2, completion2)); //"mislav"

        //"leo"       //["marina", "josipa", "nikola", "vinko", "filipa"]	["josipa", "filipa", "marina", "nikola"]	"vinko"
    }
}
