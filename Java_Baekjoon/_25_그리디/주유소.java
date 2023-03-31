package Java_Baekjoon._25_그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주유소 {

    /*각 도시에 있는 주유소의 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아
    제일 왼쪽 도시에서 제일 오른쪽 도시로 이동하는 최소의 비용을 계산하는 프로그램을 작성하시오.
    표준 출력으로 제일 왼쪽 도시에서 제일 오른쪽 도시로 가는 최소 비용을 출력한다.
    첫 번째 줄에는 도시의 개수를 나타내는 정수 N
    다음 줄에는 인접한 두 도시를 연결하는 도로의 길이가 N-1개의 자연수로 주어진다.
    다음 줄에는 주유소의 리터당 가격이 제일 왼쪽 도시부터 순서대로 N개의 자연수로 주어진다.*/

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long [] roads = new long [n-1];
        long [] price = new long [n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n-1; i++)
            roads[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            price[i] = Integer.parseInt(st.nextToken());

        long min = price[0];
        long sum = 0;

        for(int i = 0 ; i < n-1; i++) {

            min = Math.min(min, price[i]);
            sum += (roads[i] * min);
        }

        System.out.println(sum);
    }
}
