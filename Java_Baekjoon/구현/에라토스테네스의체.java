package Java_Baekjoon.구현;

import java.util.Scanner;

public class 에라토스테네스의체 {

    public static int N, K;
    public static int [] board;

    public static int solution(int n) {

        int countK = 0;

        if(n==1)
            return 0;

        for(int i=2; i<=n; i++) {
            if(board[i]==0)
                continue;

            countK++;
            board[i] = 0;
            if(countK==K)
                return i;

            for(int j=i*2; j<=n; j+=i) {
                if(board[j]==0)
                    continue;
                board[j] = 0;
                countK++;
                if(countK==K)
                    return j;
            }
        }

        return 0;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();

        board = new int [N+1];
        for(int i=2; i<=N; i++)
            board[i] = i;


        System.out.println(solution(N));
    }
}
