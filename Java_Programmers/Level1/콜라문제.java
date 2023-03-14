package Java_Programmers.Level1;

public class 콜라문제 {
    /*콜라를 받기 위해 마트에 주어야 하는 병 수 a,
    빈 병 a개를 가져다 주면 마트가 주는 콜라 병 수 b,
    상빈이가 가지고 있는 빈 병의 개수 n이 매개변수로 주어집니다.
    상빈이가 받을 수 있는 콜라의 병 수를 return 하도록 solution 함수를 작성해주세요.
    단, 보유 중인 빈 병이 2개 미만이면, 콜라를 받을 수 없다.
    * */

    public int solution(int a, int b, int n) { //a= 2, b=1, n=20
        int cola = 0;

        while (n>=a) {
            cola += (n / a) * b;
            n = (n/a)*b + n%a;
        }
        return cola;
    }


    public static void main(String[] args) {
        콜라문제 a = new 콜라문제();
        System.out.println(a.solution(2, 1, 20));   //19
        System.out.println(a.solution(3, 1, 20));   //9
        System.out.println(a.solution(5, 3, 21));   //27

    }
}
