package Java_Programmers.Level1;

import java.util.Arrays;
import java.util.Comparator;

public class 문자열내마음대로정렬하기 {

    /*문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때,
    각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
    인덱스 1의 문자가 같은 문자열이 여럿 일 경우, 사전순으로 앞선 문자열이 앞쪽에 위치합니다.*/

    public String[] solution(String[] strings, int n) {

        Arrays.sort(strings, new Comparator<String>() {

                @Override
                public int compare(String o1, String o2) {

                    if (o1.substring(n, n + 1).compareTo(o2.substring(n, n + 1)) > 0) return 1;
                    else if (o1.substring(n, n + 1).compareTo(o2.substring(n, n + 1)) < 0) return -1;
                    else {
                        if (o1.compareTo(o2) > 0) return 1;
                        else if (o1.compareTo(o2) < 0) return -1;
                        else return 0;
                    }
                }
        });

        return strings;
    }

        public static void main(String[] args) {

        문자열내마음대로정렬하기 a = new 문자열내마음대로정렬하기();

        String [] str1 = {"sun", "bed", "car"};
        System.out.println(Arrays.toString(a.solution(str1, 1))); //["car", "bed", "sun"]

        String [] str2 = {"abce", "abcd", "cdx"};
        System.out.println(Arrays.toString(a.solution(str2, 2))); //["abcd", "abce", "cdx"]
    }

}
