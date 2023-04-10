package Java_이코테._06다이나믹프로그래밍;

//f(2)가 여러번 호출됨 -> 중복 부분 문제
public class 피보나치수열_재귀 {

    public static long fibo(int x) {

        //종료조건
        if(x ==1 || x==2)
            return 1;

        return fibo(x-1) + fibo(x-2);
    }

    public static void main(String[] args) {

        System.out.println(fibo(4));
    }
}
