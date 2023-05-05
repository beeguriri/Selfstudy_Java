package Java_Programmers.Level2;

import java.util.*;

public class 뉴스클러스터링 {

    public static int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++){
            char a = str1.charAt(i);
            char b = str1.charAt(i+1);

            if(a>='a' && a<='z' && b>='a' && b<='z') {
                String temp = str1.substring(i,i+2);
                list1.add(temp);
            }
        }

        for(int i=0; i<str2.length()-1; i++){
            char a = str2.charAt(i);
            char b = str2.charAt(i+1);

            if(a>='a' && a<='z' && b>='a' && b<='z') {
                String temp = str2.substring(i,i+2);
                list2.add(temp);
            }
        }

        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        for(String s1 : list1) {
            if(list2.remove(s1))
                intersection.add(s1);
            union.add(s1);
        }

        if(!list2.isEmpty())
            union.addAll(list2);

        if(union.size()==0)
            return 65536;

        return intersection.size()*65536 / union.size();

    }

    public static void main(String[] args) {

//        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("handshake", "shake hands"));
    }
}
