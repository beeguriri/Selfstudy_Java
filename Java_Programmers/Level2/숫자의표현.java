package Java_Programmers.Level2;

public class 숫자의표현 {

    public int solution(int n) {

        int [] arr = new int [n+1];
        for (int i=0; i<=n; i++)
            arr[i] = i;

        int start=1, end = 1;
        int sum = arr[start];
        int count = 0;

        while(start <= end && end <= n) {

//            System.out.println(start + ", " + end + ", " + sum);

            if(sum == n)
                count++;

            if(sum>=n) {
                sum -= arr[start];
                start++;
            } else {
                end++;
                sum += arr[end];

            }
        }


        return count;
    }

    public int solution2(int n) {

        int start = 0;
        int sum = 0;
        int count = 0;

        for (int i=1; i<=n; i++) {

            sum += i;

            while(sum > n) {
                sum -= start;
                start += 1;
            }

            if(sum == n)
                count++;

        }


        return count;
    }

    public static void main(String[] args) {

        숫자의표현 a = new 숫자의표현();

        System.out.println(a.solution(15));

    }

}
