package Java_Baekjoon._14_집합과맵;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 회사에있는사람 {

    /*첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다. (2 ≤ n ≤ 106)
    다음 n개의 줄에는 출입 기록이 순서대로 주어지며,
    각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다.
    회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다.
    사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
    현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다. */

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();
        Set<String> employee = new HashSet<>();

        for(int i=0; i<n; i++) {
            String s = br.readLine();
            map.put(s.split(" ")[0], s.split(" ")[1]);
            employee.add(s.split(" ")[0]);
        }

        List<String> list = new ArrayList<>(employee);
        list.sort(Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for (String e : list){
            if(map.get(e).equals("enter"))
                sb.append(e).append("\n");
        }

        System.out.println(sb);

    }
}
