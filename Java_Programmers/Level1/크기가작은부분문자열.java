package Java_Programmers.Level1;

public class 크기가작은부분문자열 {
    /*숫자로 이루어진 문자열 t와 p가 주어질 때,
    t에서 p와 길이가 같은 부분문자열 중에서,
    이 부분문자열이 나타내는 수가 p가 나타내는 수보다 작거나 같은 것이 나오는
    횟수를 return하는 함수 solution을 완성하세요.
     */

    //런타임에러가 나면 Int -> Long으로 바꿔서 해보기
    public int solution(String t, String p) {
        int answer = 0;
        for(int i = 0; i<=t.length()-p.length(); i++) {
            String temp = t.substring(i, p.length()+i);
            if(Long.parseLong(temp)<=Long.parseLong(p))
                answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        크기가작은부분문자열 a = new 크기가작은부분문자열();

        System.out.println(a.solution("3141592", "271")); //2
        System.out.println(a.solution("500220839878", "7")); //8
        System.out.println(a.solution("10203", "15")); //3

    }
}
