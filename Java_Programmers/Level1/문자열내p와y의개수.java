package Java_Programmers.Level1;

import java.util.Arrays;

public class 문자열내p와y의개수 {

    /* 대문자와 소문자가 섞여있는 문자열 s가 주어집니다.
    s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True,
    다르면 False를 return 하는 solution를 완성하세요.
    'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
    단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
     * */

    boolean solution(String s) {

        int p = 0;
        int y = 0;
        s = s.toLowerCase();

        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i)=='p') p++;
            else if(s.charAt(i)=='y') y++;
        }

        return (p==y)? true: false;
    }

    public static void main(String[] args) {
        문자열내p와y의개수 a = new 문자열내p와y의개수();

        System.out.println(a.solution("pPoooyY")); //true
        System.out.println(a.solution("Pyy"));  //false
    }
}
