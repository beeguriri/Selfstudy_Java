package Java_Programmers.Level1;

public class 둘만의암호 {

    /*문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
    index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
    skip에 있는 알파벳은 제외하고 건너뜁니다.*/

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        String str = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0 ; i <skip.length(); i++)
            str = str.replace(skip.substring(i,i+1), "");

        for(int i = 0; i<s.length(); i++) {
            int c = str.indexOf(s.charAt(i)) + index;
            char ch = str.charAt(c%str.length());
            answer.append(ch);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        둘만의암호 a = new 둘만의암호();

        System.out.println((int)'a'); //97
        System.out.println((int)'z'); //122

        System.out.println(a.solution("aukks","wbqd",5));   //happy
    }
}
