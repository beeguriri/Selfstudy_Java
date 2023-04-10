package Java_이코테._06다이나믹프로그래밍;

//재귀 이용
public class 피보나치수열_Top_Down {

    public static long [] d = new long [100];

    public static long fibo(int x) {

        if(x==1 || x==2)
            return 1;

        if (d[x] != 0)
            return d[x];

        d[x] = fibo(x-1) + fibo(x-2);

        return d[x];
    }

    public static void main(String[] args) {

        System.out.println(fibo(10));
        System.out.println(fibo(50));
    }
}
