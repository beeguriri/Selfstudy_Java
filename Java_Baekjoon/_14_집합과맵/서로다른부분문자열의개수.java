package Java_Baekjoon._14_집합과맵;

import java.util.*;

public class 서로다른부분문자열의개수 {

    /*첫째 줄에 문자열 S가 주어진다. S는 알파벳 소문자로만 이루어져 있고, 길이는 1,000 이하이다.
    첫째 줄에 S의 서로 다른 부분 문자열의 개수를 출력한다. */

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Set<String> set = new HashSet<>();
        List<String> list = new ArrayList<>();

        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length()+1; j++) {
                set.add(str.substring(i,j));
                list.add(str.substring(i,j));
            }
        }

        System.out.println(set);
        System.out.println(set.size());
        System.out.println(list);
        System.out.println(list.size());
    }
}
