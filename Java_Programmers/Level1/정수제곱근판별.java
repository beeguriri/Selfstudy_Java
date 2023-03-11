package Java_Programmers.Level1;

public class 정수제곱근판별 {

    /*임의의 양의 정수 n에 대해, n이 어떤 양의 정수 x의 제곱인지 아닌지 판단하려 합니다.
    n이 양의 정수 x의 제곱이라면 x+1의 제곱을 리턴하고,
    n이 양의 정수 x의 제곱이 아니라면 -1을 리턴하는 함수를 완성하세요.
    제한 사항 : n은 1이상, 50000000000000 이하인 양의 정수입니다.*/

    //시간초과 개선
    //제곱근 : Math.sqrt(n) => double
    //제곱 : Math.pow(x,n) => double (x^n)
    public long solution(long n) {
        long answer = 0;
        long n1 = (int) (Math.sqrt(n));
        double n2 = Math.sqrt(n);

        if(n1==n2) answer = (n1+1)*(n1+1);
        else answer = -1;
        return answer;
    }

    public static void main(String[] args) {
        정수제곱근판별 a = new 정수제곱근판별();

            System.out.println(a.solution(121));    //144
            System.out.println(a.solution(3));      //-1
    }
}
