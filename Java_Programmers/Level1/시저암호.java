package Java_Programmers.Level1;

public class 시저암호 {

    /*어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
    예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
    "z"는 1만큼 밀면 "a"가 됩니다.
    문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
     */

    public String solution(String s, int n) {
        String answer ="";
        char [] ch = s.toCharArray();

        for(char c : ch) {
            if(c == ' ') {
                answer += String.valueOf(c);
                continue;
            }
  
            if(c >= 'a' && c<= 'z') {
                if((int)c + n > 'z')
                    answer += String.valueOf((char) ((int)c + n - 26));
                else answer += String.valueOf((char)((int)c + n));
            }

            if(c >= 'A' && c <= 'Z') {
                if ((int)c+n > 'Z')
                    answer += String.valueOf((char)((int)c + n - 26));
                else answer += String.valueOf((char)((int)c + n));
            }
        }

        return answer;
    }


    public static void main(String[] args) {

        시저암호 a = new 시저암호();

        System.out.println(a.solution("AB", 1)); //"BC"
        System.out.println(a.solution("z", 1)); //"a"
        System.out.println(a.solution("a B z", 4)); //"e F d"
        System.out.println(a.solution("P",15)); //E
        System.out.println(a.solution("AaZz", 25)); //ZzYy
        System.out.println(a.solution("a    b", 1)); //"b    c"
        System.out.println(a.solution("a b ", 1)); //"b c  "

//        System.out.println((int)('a'));//97
//        System.out.println((int)('z'));//122
//        System.out.println((int)(' '));//32
//        System.out.println((int)('A')); //65
//        System.out.println((int)('Z')); //90




    }
}
