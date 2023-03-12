package Java_Programmers.Level1;

public class _3진법뒤집기 {
    /*자연수 n이 매개변수로 주어집니다.
    n을 3진법 상에서 앞뒤로 뒤집은 후,
    이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.
     */
    public int solution(int n) {
        String [] s3Arr = Integer.toString(n,3).split("");
        String temp = "";
        for(String s : s3Arr)
            temp = s + temp;
        return Integer.parseInt(temp, 3);
    }

    public static void main(String[] args) {
        _3진법뒤집기 a = new _3진법뒤집기();

        System.out.println(a.solution(45));     //7
        System.out.println(a.solution(125));    //229
    }
}
