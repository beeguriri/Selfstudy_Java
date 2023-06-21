package Java_Baekjoon._23_동적계획법;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 피보나치함수 {

    public static int [] dpZero = new int [41];
    public static int [] dpOne = new int [41];

    public static int fibonacci(int n) {

        if(n==0) {
            return 0;
        }
        else if(n==1) {
            return 1;
        }
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void countZeroOne(int x){

        dpZero[0] = 1; dpZero[1] = 0;
        dpOne[0] = 0; dpOne[1] = 1;

        for(int i=2; i<=x; i++) {
            dpZero[i] = dpZero[i-1] + dpZero[i-2];
            dpOne[i] = dpOne[i-1] + dpOne[i-2];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            int x = Integer.parseInt(br.readLine());
            countZeroOne(x);
            sb.append(dpZero[x]).append(" ").append(dpOne[x]).append("\n");
        }

        System.out.print(sb);
    }
}
