package Java_Baekjoon._25_그리디;

import java.io.*;

public class 세탁소사장동혁 {
    /*거스름돈의 액수가 주어지면 리암이 줘야할
    쿼터(Quarter, $0.25)의 개수, 다임(Dime, $0.10)의 개수, 니켈(Nickel, $0.05)의 개수, 페니(Penny, $0.01)의 개수를 구하는 프로그램을 작성하시오.
    거스름돈은 항상 $5.00 이하이고, 손님이 받는 동전의 개수를 최소로 하려고 한다.
    입력 : 첫째 줄에 테스트 케이스의 개수 T가 주어진다.
    각 테스트 케이스는 거스름돈 C를 나타내는 정수 하나로 이루어져 있다. C의 단위는 센트이다. (1달러 = 100센트) (1<=C<=500)
    출력 : 각 테스트케이스에 대해 필요한 쿼터의 개수, 다임의 개수, 니켈의 개수, 페니의 개수를 공백으로 구분하여 출력한다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());    //테스트 케이스 갯수
        StringBuilder sb = new StringBuilder();

        int quarter = 25;
        int dime = 10;
        int nickel = 5;

        for(int i = 0; i<t; i++) {
            int total = Integer.parseInt(br.readLine());
            sb.append(total / quarter).append(" ");
            total %= quarter;
            sb.append(total / dime).append(" ");
            total %= dime;
            sb.append(total / nickel).append(" ");
            sb.append(total % nickel).append("\n");
        }

        System.out.println(sb);

        //예제
        //124 => 4 2 0 4
        //25 => 1 0 0 0
        //194 => 7 1 1 4

    }
}
