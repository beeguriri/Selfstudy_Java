package Java_Programmers.Level2;

public class _3xn타일링 {

    //경우의 수가 많아 질 수 있으므로, 경우의 수를 1,000,000,007으로 나눈 나머지를 return해주세요.

    public static final int MOD = 1000000007;

    public static long solution(int n) {

        long [] d = new long[n+1];
        d[0] = 1;
        d[2] = 3;

        for(int i=4; i<=n; i+=2) {
            d[i] = ((d[i-2]*4%MOD) - (d[i-4]%MOD) + MOD) % MOD;
        }

        return d[n];
    }

    public static void main(String[] args) {
        System.out.println(solution(4));
        System.out.println(solution(6));

    }
}
