package Java_Baekjoon._03_반복문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 영수증 {

    /*첫째 줄에는 영수증에 적힌 총 금액 X가 주어진다.
     둘째 줄에는 영수증에 적힌 구매한 물건의 종류의 수 N이 주어진다.
    이후 각 물건의 가격 a와 개수 b가 공백을 사이에 두고 주어진다.
    일치하면 Yes를 출력한다. 일치하지 않는다면 No를 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i<n; i++) {
            String s = br.readLine();
            int a = Integer.parseInt(s.split(" ")[0]);
            int b = Integer.parseInt(s.split(" ")[1]);
            sum += a*b;
        }

        if(x==sum) System.out.println("Yes");
        else System.out.println("No");

    }
}
