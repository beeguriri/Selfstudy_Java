package Java_이코테.ch03그리디;

public class _1이될때까지 {
    /* N이 주어질때
    K로 나누거나 1을 빼거나 두가지의 연산을 해서
    N을 1로 만드는 최소경우
    * */
    /*최대한 많이 나누기*/
    public static void main(String[] args) {

        int n = 25; int k = 3;
        int answer = 0;

        while(n>1) {
            if(n%k==0){
                n = n/k;
            } else {
                n = n-1;
            }
            answer++;
        }
        System.out.println(answer);

        //매우 큰 수가 들어왔을때 빠르게 동작하려면..
        n=25;
        int result = 0;

        while (true) {

            // N이 K로 나누어 떨어지는 수가 될 때까지만 1씩 빼기
            int target = (n / k) * k;
            result += (n - target);
            n = target; //n을 k의 배수로 만들어줌

            // N이 K보다 작을 때 (더 이상 나눌 수 없을 때) 반복문 탈출
            if (n < k) break;

            // K로 나누기
            n /= k;
            result += 1;
        }

        // 마지막으로 남은 수에 대하여 1씩 빼기
        result += (n - 1);


        System.out.println(result);

    }
}