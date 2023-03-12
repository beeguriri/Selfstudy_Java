package Java_Programmers.Level1;

public class 약수의개수와덧셈 {
    /*두 정수 left와 right가 매개변수로 주어집니다.
    left부터 right까지의 모든 수들 중에서, 약수의 개수가 짝수인 수는 더하고,
    약수의 개수가 홀수인 수는 뺀 수를 return 하도록 solution 함수를 완성해주세요.
    제한사항 : 1 ≤ left ≤ right ≤ 1,000 */

    public int solution(int left, int right) {
        int answer = 0;
        int n = left;
        int cnt = 0;

        while(n<=right) {
            for(int i = 1; i<=n; i++)
                if(n%i==0)  cnt++;

            if(cnt%2==0) answer +=n;
            else answer -= n;

            n++;
            cnt = 0;
        }


        return answer;
    }

    public static void main(String[] args) {
        약수의개수와덧셈 a = new 약수의개수와덧셈();

        System.out.println(a.solution(13,17));  //43
        System.out.println(a.solution(24,27));  //52

    }
}
