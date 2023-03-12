package Java_Programmers.Level1;

public class 가운데글자가져오기 {
    /*단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요.
    단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.*/

    public String solution(String s) {
        String answer = "";
        if(s.length()%2!=0)
            answer = s.substring(s.length()/2,(s.length()/2)+1);
        else
            answer = s.substring((s.length()/2)-1, (s.length()/2)+1);

        return answer;
    }

    public static void main(String[] args) {
        가운데글자가져오기 a = new 가운데글자가져오기();

        System.out.println(a.solution("abcde"));    //c (5/2 -> 2)
        System.out.println(a.solution("qwer"));     //we (4/2 -> 1,2)

    }
}
