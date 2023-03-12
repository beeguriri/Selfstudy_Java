package Java_Programmers.Level1;

import java.util.Arrays;

public class 최대공약수와최소공배수 {

    /*두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수,
    solution을 완성해 보세요.
    배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. */

    static int gcdF (int n, int m) {
        if (m==0) return n;
        else return gcdF(m,n%m);
    }

    public int[] solution(int n, int m) {
        int[] answer = new int [2];

        //최대공약수
        answer[0] = gcdF(n, m);

        //최소공배수
        n = n/answer[0];
        m = m/answer[0];
        answer[1] = answer[0]*n*m;

        return answer;
    }

    public static void main(String[] args) {
        최대공약수와최소공배수 a = new 최대공약수와최소공배수();

        System.out.println(Arrays.toString(a.solution(3,12))); //[3, 12]
        System.out.println(Arrays.toString(a.solution(2,5))); //[1, 10]
    }
}
