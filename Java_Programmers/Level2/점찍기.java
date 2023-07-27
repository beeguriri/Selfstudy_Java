package Java_Programmers.Level2;

public class 점찍기 {

    public static long solution(int k, int d) {
        long answer = 0;

        //x^2 + y^2 = d^2 => y = sqrt(d^2 - x^2)
        for(int i=0; i<=d; i+=k) {
            long y = (long) Math.sqrt(Math.pow(d,2) - Math.pow(i,2));
            answer += ((y/k)+1);
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 4));
        System.out.println(solution(1, 5));
    }
}
