package Java_Programmers.Level1;
public class 문자열다루기기본 {

    /*문자열 s의 길이가 4 혹은 6이고,
    숫자로만 구성돼있는지 확인해주는 함수, solution을 완성하세요.
    예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
     */

    public boolean solution(String s) {
        boolean answer = false;
        int cnt = 0;

        if(s.length()==4 || s.length()==6) {
            char [] temp = s.toCharArray();
            for(char c : temp)
                if(Character.isDigit(c))    cnt++;
            if(cnt==s.length()) answer = true;
        }

        return answer;
    }

    public static void main(String[] args) {
        문자열다루기기본 a = new 문자열다루기기본();

        System.out.println(a.solution("a234")); //false
        System.out.println(a.solution("1234")); //true

    }

}
