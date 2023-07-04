package Java_Programmers.Level2;

import java.util.*;

public class 오픈채팅방 {

    //첫 단어는 Enter, Leave, Change 중 하나이다.
    //Enter uid1234 Muzi
    public static String[] solution(String[] record) {

        Map<String, String> map = new HashMap<>(); //유저아이디, 닉네임
        List<String> list = new ArrayList<>(); //메시지 저장
        String [] msg;

        //userid 최종버전 갱신 후
        for(String s : record) {
            msg = s.split(" ");
            if(msg.length==3)
                map.put(msg[1], msg[2]);
        }

        //채팅 메시지 생성
        for(String s : record) {
            msg = s.split(" ");
            if(msg[0].equals("Enter"))
                list.add(map.get(msg[1])+"님이 들어왔습니다.");
            else if (msg[0].equals("Leave"))
                list.add(map.get(msg[1])+"님이 나갔습니다.");
        }

        return list.toArray(String[]::new);
    }

    public static void main(String[] args) {

        String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo",
                "Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));

    }
}
