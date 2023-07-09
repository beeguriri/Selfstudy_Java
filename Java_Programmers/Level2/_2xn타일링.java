package Java_Programmers.Level2;

public class _2xn타일링 {

    //경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.
    public static int solution(int n) {

        long [] d = new long [n+1];
        d[0] = 1; d[1] = 1;
        for(int i=2; i<=n; i++)
            d[i] = (d[i-2] + d[i-1]) % 1000000007;

        return (int) d[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4)); //5
    }
}
