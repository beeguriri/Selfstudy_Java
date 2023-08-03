package Java_Baekjoon._13_정렬;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 접미사배열 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        List<String> list = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            list.add(s.substring(i));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for(String str : list)
            sb.append(str).append("\n");

        System.out.print(sb);
    }
}
