package Java_이코테._06다이나믹프로그래밍;

//반복문 이용
public class 피포나치수열_Bottom_Up {

    public static long d[] = new long [100];

    public static long fibo(int x) {

        d[1] = 1;
        d[2] = 1;

        for(int i=3; i<=x; i++)
            d[i] = d[i-1] + d[i-2];

        return d[x];
    }

    public static void main(String[] args) {

        System.out.println(fibo(10));
        System.out.println(fibo(50));

    }
}
