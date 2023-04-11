package Java_이코테._06다이나믹프로그래밍;

import java.util.Scanner;

public class 바닥공사 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] d = new int [1001];

        d[1] = 1;
        d[2] = 3;

        for(int i=3; i<=n; i++)
            d[i] = (d[i-1] + 2*d[i-2]) % 796796;

        System.out.println(d[n]);
    }
}
