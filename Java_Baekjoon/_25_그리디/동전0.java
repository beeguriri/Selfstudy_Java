package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 동전0 {

    /*준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
    동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다.
    이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String temp = br.readLine();
        int n = Integer.parseInt(temp.split(" ")[0]);
        int total = Integer.parseInt(temp.split(" ")[1]);
        int [] coins = new int [n];
        int cnt = 0;

        for(int i = 0; i < n; i++)
            coins[i] = Integer.parseInt(br.readLine());

        for (int i = coins.length-1; i>=0; i-- ){
            cnt += total / coins[i];
            total %= coins[i];
        }

        System.out.println(cnt);




    }

}
