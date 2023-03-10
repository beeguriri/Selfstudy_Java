package Java_Programmers.Level1;

public class 짝수와홀수 {

    /*정수 num이 짝수일 경우 "Even"을 반환하고
    홀수인 경우 "Odd"를 반환하는 함수, solution을 완성해주세요.
    0은 짝수입니다.
     */
    public String solution(int num) {
        if (Math.abs(num)%2==0 || num==0) return "Even";
        else return "Odd";
    }

    public static void main(String[] args) {
        짝수와홀수 a = new 짝수와홀수();

        System.out.println(a.solution(4));
        System.out.println(a.solution(3));
        System.out.println(a.solution(0));
        System.out.println(a.solution(-2));
    }
}
