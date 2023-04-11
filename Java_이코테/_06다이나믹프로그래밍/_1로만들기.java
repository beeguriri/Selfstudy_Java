package Java_이코테._06다이나믹프로그래밍;

public class _1로만들기 {

    /* x가 5로 나누어 떨어지면, 5로 나눈다
    x가 3으로 나누어 떨어지면, 3으로 나눈다
    x가 2로 나누어 떨어지면, 2로 나눈다.
    x에서 1을 뺀다 */

    public static long [] d = new long [30001];

    public static void main(String[] args) {

        int x = 26; //출력 => 3
        // 다이나믹 프로그래밍(Dynamic Programming) 진행(보텀업)
        for (int i = 2; i <= x; i++) {
            // 현재의 수에서 1을 빼는 경우
            d[i] = d[i - 1] + 1;
            // 현재의 수가 2로 나누어 떨어지는 경우
            if (i % 2 == 0)
                d[i] = Math.min(d[i], d[i / 2] + 1);
            // 현재의 수가 3으로 나누어 떨어지는 경우
            if (i % 3 == 0)
                d[i] = Math.min(d[i], d[i / 3] + 1);
            // 현재의 수가 5로 나누어 떨어지는 경우
            if (i % 5 == 0)
                d[i] = Math.min(d[i], d[i / 5] + 1);
        }

        System.out.println(d[x]);

    }
}
