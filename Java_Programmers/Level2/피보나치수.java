package Java_Programmers.Level2;

public class 피보나치수 {

    public long solution(int n) {

        long [] arr = new long[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i=2; i<=n; i++)
            arr[i] = (arr[i-1] + arr[i-2]) % 1234567;

        return arr[n];
    }
}
