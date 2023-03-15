package Java_Programmers.Level1;

public class 소수찾기 {
    /*1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
    소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.
    (1은 소수가 아닙니다.)*/

    //소수찾기 : "에라토스테네스의 체" 이용
    public int solution(int n) {

        //찾을 소수의 범위 배열 선언
        int [] prime = new int [n+1];
        int answer = 0;

        //prime 배열 초기화
        prime[0]=prime[1]=0;
        for(int i=2; i<=n; i++)
            prime[i] = i;

        //소수이면 0
        for(int i =2; i<n; i++){
            if(prime[i]==0) continue;

            //i의 배수는 소수가 아니므로 0
            for(int j=2*i; j<=n; j+=i)
                prime[j] = 0;
        }

        //개수 구하기
        for(int i=0; i<prime.length; i++)
            if(prime[i]!=0) answer++;

        return answer;
    }



    //원래코드 : 시간초과
    public int solution1(int n) {
        int answer = 0;
        for(int i =2; i<=n; i++) {
            int cnt = 0;
            for(int j=1; j<=i; j++) {
                if (i % j == 0) {
                    cnt++;
                    if(cnt>2) break;
                }
            }
            if (cnt == 2) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        소수찾기 a = new 소수찾기();

        System.out.println(a.solution(10)); //4
        System.out.println(a.solution(5)); //3

    }
}
