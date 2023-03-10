package Java_Programmers.Level1;

public class 자릿수더하기 {
    /*자연수 N이 주어지면, N의 각 자릿수의 합을 구해서 return 하는 solution 함수를 만들어 주세요.
      예를들어 N = 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.*/

    public int solution(int n) {
        int answer = 0;
        String [] strN = String.valueOf(n).split("");
        for (String s : strN)
            answer += Integer.parseInt(s);

        return answer;
    }
    public static void main(String[] args) {
        자릿수더하기 a = new 자릿수더하기();

        System.out.println(a.solution(123));    //6
        System.out.println(a.solution(987));    //24
    }
}
