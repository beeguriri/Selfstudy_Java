package Java_Programmers.Level1;

public class 옹알이2 {

    /* 조카는 아직 "aya", "ye", "woo", "ma" 네 가지 발음과
    네 가지 발음을 조합해서 만들 수 있는 발음밖에 하지 못하고
    연속해서 같은 발음을 하는 것을 어려워합니다.
    문자열 배열 babbling이 매개변수로 주어질 때,
    머쓱이의 조카가 발음할 수 있는 단어의 개수를 return하도록 solution 함수를 완성해주세요.
    * */
    public int solution(String[] babbling) {
        int answer = 0;
        String [] ano = {"aya", "ye", "woo", "ma"};

        for (String b : babbling){
            for(String a : ano) {
                if(!b.contains(a+a)) {
                    b = b.replace(a," ");
                }
            }
            b= b.replace(" ", "");
            if (b.length()==0) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        옹알이2 a = new 옹알이2();

        String[] babbling1 = {"aya", "yee", "u", "maa"};
        System.out.println(a.solution(babbling1)); //1

        String[] babbling2 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        System.out.println(a.solution(babbling2)); //2
    }
}
