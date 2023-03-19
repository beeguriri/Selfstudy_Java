package Java_Programmers.Level1;

import java.util.*;

public class 신고결과받기 {
    /*각 유저는 한 번에 한 명의 유저를 신고할 수 있습니다.
     한 유저를 여러 번 신고할 수도 있지만, 동일한 유저에 대한 신고 횟수는 1회로 처리됩니다.
     k번 이상 신고된 유저는 게시판 이용이 정지되며, 해당 유저를 신고한 모든 유저에게 정지 사실을 메일로 발송합니다.
     유저가 신고한 모든 내용을 취합하여 마지막에 한꺼번에 게시판 이용 정지를 시키면서 정지 메일을 발송합니다.*/

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        //report의 중복 제거
        ArrayList<String> temp = new ArrayList<>(new HashSet<>(Arrays.asList(report)));
        //List<String> list = Arrays.stream(report).distinct().collect(Collectors.toList());

        // id_list 당 신고한 목록
        HashMap<String, ArrayList<String>> reporter = new HashMap<>();
        //신고당한 목록과 횟수
        HashMap<String, Integer> yellow = new HashMap<>();

        //초기화
        for (String id : id_list) {
            reporter.put(id, new ArrayList<>());
            yellow.put(id, 0);
        }

        //temp배열 순회
        for (int i = 0; i < temp.size(); i++) {
            String r = temp.get(i).split(" ")[0]; //신고자
            String y = temp.get(i).split(" ")[1]; //신고당한자

            //신고자가 신고했던 목록에 추가
            ArrayList<String> member = reporter.get(r);
            member.add(y);
            reporter.put(r, member);

            //신고당한자 count
            yellow.put(y, yellow.get(y) + 1);
        }

        //결과 반환
        for (int i = 0; i < id_list.length; i++) {
            ArrayList<String> list = reporter.get(id_list[i]);

            if (!list.isEmpty()) {
                for (int j = 0; j < list.size(); j++) {
                    if (yellow.get(list.get(j)) >= k) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }

    public static void main (String[]args){
        신고결과받기 a = new 신고결과받기();

        String[] id = {"muzi", "frodo", "apeach", "neo"};
        String[] rep = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        System.out.println(Arrays.toString(a.solution(id, rep, 2))); //[2,1,1,0]
    }
}

