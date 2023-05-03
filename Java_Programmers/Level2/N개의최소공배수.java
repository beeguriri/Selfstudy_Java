package Java_Programmers.Level2;

public class N개의최소공배수 {

    public static long GCD (long a, long b) {

        if(b==0)
            return a;

        return GCD(b, a%b);
    }

    public long solution(int[] arr) {

        long answer = arr[0];

        for(int i=1; i<arr.length; i++){

            long gcd = GCD(answer, arr[i]);

            answer = answer * arr[i] / gcd;


        }

        return answer;
    }
}
